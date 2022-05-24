package kr.co.ffm.system.watertankstatus;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kr.co.ffm.system.watertank.Watertank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class WatertankStatusController {
    @Autowired
    private WatertankStatusService watertankStatusService;

    @GetMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
    public List<WatertankStatus> watertankStatusList(WatertankStatus watertankStatus) {
        List<WatertankStatus> statusList = watertankStatusService.viewWatertankStatusList(watertankStatus);

        return statusList;
    }

    @PostMapping
    public String receiveWatertankStatus(WatertankStatus watertankStatus) {
        watertankStatusService.receiveWatertankStatus(watertankStatus);

        Gson response = new Gson();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code", "200");
        jsonObject.addProperty("message", "null");

        return response.toJson(jsonObject);
    }
}
