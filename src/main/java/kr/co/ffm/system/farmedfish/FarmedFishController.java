package kr.co.ffm.system.farmedfish;

import kr.co.ffm.system.page.Page;
import kr.co.ffm.system.page.PageUtil;
import kr.co.ffm.system.watertank.Watertank;
import kr.co.ffm.system.watertank.WatertankService;
import kr.co.ffm.system.watertank.WatertankViewInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/farmedfish")
public class FarmedFishController {

    @Autowired
    private FarmedFishService farmedFishService;
    @Autowired
    private WatertankService watertankService;
    @Autowired
    private PageUtil pageUtil;

    @PostMapping
    public ModelAndView registFarmedFish(FarmedFish farmedFish) {
        System.out.println("farmedFish.getFeedingTime = " + farmedFish.getFeedingTime());
        farmedFishService.registFarmedFish(farmedFish);

        return new ModelAndView("redirect:/farmedfish");
    }

    @GetMapping
    public ModelAndView viewFarmedFishList() {

        return new ModelAndView("farmedfish/list");
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String viewFarmedFishList(FarmedFish farmedFish,
                                     Page page) {
        List<FarmedFish> farmedFishList =
                farmedFishService.viewFarmedFishList(farmedFish);

        page = pageUtil.setPage(farmedFish.getNo(),
                                farmedFishList.size(),
                                page.getPageNo());

        return pageUtil.drawPage(page, farmedFishList);
    }

    @GetMapping("/{no}")
    public ModelAndView viewFarmedFish(FarmedFish farmedFish) {
        ModelAndView mav = new ModelAndView("farmedfish/view");
        mav.addObject("farmedFish", farmedFishService.viewFarmedFish(farmedFish));

        Watertank watertank = new Watertank();
        watertank.setFarmedFishNo(farmedFish.getNo());

        List<WatertankViewInfo> watertankViewInfoList = watertankService.viewWatertankList(watertank);
        System.out.println(watertankService.viewWatertankList(watertank));

        if (watertankViewInfoList.size() != 0) {
            Iterator<WatertankViewInfo> iterator = watertankViewInfoList.iterator();
            //해당 양식어를 사용하는 수조 중에서 하나라도 활성 상태면 비활성으로 못 바꾸게 한다.
            while (iterator.hasNext()) {
                if (iterator.next().getActive().equals("Y")) {
                    mav.addObject("existence", true);
                    return mav;
                }
            }
        }
        mav.addObject("existence", false);

        return mav;
    }

    @PutMapping
    public ModelAndView editFarmedFish(FarmedFish farmedFish) {
        ModelAndView mav = new ModelAndView("redirect:/farmedfish/" + farmedFish.getNo());

        if (farmedFishService.viewFarmedFish(farmedFish).getActive().equals("Y")) {
            farmedFish.setActive("N");
            farmedFishService.editFarmedFish(farmedFish);
        } else {
            farmedFish.setActive("Y");
            farmedFishService.editFarmedFish(farmedFish);
        }

        return mav;
    }
}
