package kr.co.ffm.system.watertank;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/watertank")
public class WatertankController {
    private static Logger logger
            = LogManager.getLogger(WatertankController.class);

    @Autowired
    private WatertankService watertankService;

    @GetMapping
    public ModelAndView watertankList() {
        return new ModelAndView("watertank/list");
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<WatertankViewInfo> watertankList(Watertank watertank) {
        List<WatertankViewInfo> infoList = watertankService.viewWatertankList(watertank);
        return infoList;
    }

    @GetMapping("/{id}")
    public ModelAndView viewWatertank(Watertank watertank) {
        Watertank result = watertankService.viewWatertank(watertank);

        ModelAndView mov = new ModelAndView("watertank/view");
        mov.addObject("result", result);

        return mov;
    }

    @PostMapping
    public ModelAndView editWatertank(Watertank watertank) {
        watertankService.editWatertank(watertank);

        return new ModelAndView(new RedirectView("/wartertank/" + watertank.getId()));
    }

    @PostMapping("/info")
    public String receiveWatertank(Watertank watertank) {
        watertankService.receiveWatertank(watertank);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"code\" : ");
        stringBuilder.append("\"200\"");
        stringBuilder.append(", \"message\" : ");
        stringBuilder.append("null");
        stringBuilder.append("}");

        String response = stringBuilder.toString();

        return response;
    }
}
