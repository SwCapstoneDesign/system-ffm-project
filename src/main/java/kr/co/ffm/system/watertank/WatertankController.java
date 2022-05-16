package kr.co.ffm.system.watertank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class WatertankController {
    @Autowired
    private WatertankService watertankService;

    @GetMapping
    public ModelAndView watertankList() {
        return null;
    }

    @GetMapping
    public List<WatertankViewInfo> watertankList(Watertank watertank) {
        return null;
    }

    @GetMapping
    public ModelAndView viewWatertank(Watertank watertank) {
        return null;
    }

    @PostMapping
    public ModelAndView editWatertank(Watertank watertank) {
        return null;
    }

    @PostMapping
    public String receiveWatertank(Watertank watertank) {
        return null;
    }
}
