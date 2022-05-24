<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/view/include/head.jsp" %>

    <title>수조 정보 목록 조회</title>
</head>
<body style="font-family: 'Noto Sans KR', sans-serif;">
<div class="ts-page-wrapper ts-has-bokeh-bg" id="page-top">
    <%@ include file="/WEB-INF/view/include/header.jsp" %>
    <main id="ts-main">
        <section id="page-title" style="height: 40px">
            <div class="container">
                <div class="ts-title mb-0">
                    <div class="row">
                        <div class="ts-title mb-1 col-sm-11">
                            <input class="form-control" type="text" id = "searchFarmedFishByName" name="searchFarmedFishByName" size="100" placeholder="양식어명">
                        </div>
                        <div class="ts-title mb-1 col-sm-1">
                            <input class="btn btn-primary w-100" type="button" value="검색" id="search">
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="items-grid">
            <div class="container">
                <div class="row" id="table">
                </div>
            </div>
        </section>
    </main>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
    var url = '/watertank';

    $(document).ready(function (){
        drawTable();
        $("#search").click(function (){
            $("#table").html("");
            drawTable();
        });
    });

    function drawTable() {
        $.ajax({
            url:'/watertank',
            data:{
                'farmedFishName' : $("#keywordName").val()
            },
            type:'GET',
            dataType:'json',
            headers: { "Content-Type" : "application/json;charset=UTF-8" },
            success:function (result) {
                console.log(this.data)
                var script = "";

                for (var i = 0; i < result.length; i++) {
                    script += '<div class="col-sm-6 col-lg-4">'
                    script += '    <div class="card ts-item ts-card ts-item__lg">'
                    script += '        <a href="${pageContext.servletContext.contextPath}/watertank/' + result[i].id + '">'
                    script += '            <div class="card-body bg-primary text-white ts-border-radius__lg">'
                    script += '                <div class="ts-description-lists text-center">'
                    script += '                    수조 ID :' + result[i].id + '<br>'
                    script += '                    양식어 명 :' + result[i].farmedFishName + '<br>'

                    if(result[i].statusList.length < 1) {
                        script += '                    수온 : null <br>'
                    } else {
                        script += '                    수온 :' + result[i].statusList[0].temperature + '<br>'
                    }

                    if(result[i].statusList.length < 1) {
                        script += '                    산도 : null <br>'
                    } else {
                        script += '                    산도 :' + result[i].statusList[0].ph + '<br>'
                    }

                    if(result[i].statusList.length < 1) {
                        script += '                    용존산소량 : null'
                    } else {
                        script += '                    용존산소량 :' + result[i].statusList[0].oxygen
                    }

                    script += '                </div>'
                    script += '            </div>'
                    script += '        </a>'
                    script += '    </div>'
                    script += '</div>'
                }
                $("#table").html(script);
            }
        });
    }
</script>
<%@ include file="/WEB-INF/view/include/bottom.jsp" %>
</html>
