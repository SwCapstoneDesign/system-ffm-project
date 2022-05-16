package kr.co.ffm.system.farmedfish;

import kr.co.ffm.system.page.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/farmedfish")
public class FarmedFishController {
    @PostMapping
    public ModelAndView registFarmedFish(FarmedFish farmedFish) {
//        redirect : /farmedfish
        return null;
    }

    @GetMapping
    public List<FarmedFish> viewFarmedFishList(FarmedFish farmedFish,
                                               Page page) {
        return null;
    }
}
