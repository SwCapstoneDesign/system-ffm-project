package kr.co.ffm.system.farmedfish;

import kr.co.ffm.system.page.Page;
import kr.co.ffm.system.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/farmedfish")
public class FarmedFishController {

    @Autowired
    private FarmedFishService farmedFishService;
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
