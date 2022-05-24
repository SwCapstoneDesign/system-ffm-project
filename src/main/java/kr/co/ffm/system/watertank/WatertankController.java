package kr.co.ffm.system.watertank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
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

    @PutMapping
    public ModelAndView editWatertank(Watertank watertank) {
        watertankService.editWatertank(watertank);

        return new ModelAndView(new RedirectView("/wartertank/" + watertank.getId()));
    }

    @PostMapping(value = "/info", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String receiveWatertank(@RequestBody Watertank watertank) {
        watertankService.receiveWatertank(watertank);

        Gson response = new Gson();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code", "200");
        jsonObject.addProperty("message", "null");

        return response.toJson(jsonObject);
    }
}
