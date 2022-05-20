package kr.co.ffm.system.farmedfish;

import kr.co.ffm.system.page.Page;
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

    @PostMapping
    public ModelAndView registFarmedFish(FarmedFish farmedFish) {
        ModelAndView mav = new ModelAndView("redirect:/farmedfish");
        farmedFishService.registFarmedFish(farmedFish);

        return mav;
    }

    @GetMapping
    public ModelAndView viewFarmedFishList() {
        return new ModelAndView("farmedfish/list");
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<FarmedFish> viewFarmedFishList(FarmedFish farmedFish,
                                               Page page) {
        List<FarmedFish> farmedFishList =
                farmedFishService.viewFarmedFishList(farmedFish);

        return farmedFishList;
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
        farmedFishService.editFarmedFish(farmedFish);

        return mav;
    }
}
