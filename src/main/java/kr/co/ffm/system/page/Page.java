package kr.co.ffm.system.page;

import lombok.Data;

import java.io.Serializable;

@Data
public class Page implements Serializable {
    private int no;
    private int StartPageNo;
    private int EndPageNo;
    private int finalPageNo;
    private int totalRowCount;
    private int pageNo;
    private int startRn;
    private int endRn;
}
