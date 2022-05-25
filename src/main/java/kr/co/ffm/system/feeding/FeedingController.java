package kr.co.ffm.system.feeding;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kr.co.ffm.system.farmedfish.FarmedFish;
import kr.co.ffm.system.watertank.Watertank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feeding")
public class FeedingController {
    @Autowired
    private FeedingService feedingService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Feeding> feedingList(Watertank watertank) {
        List<Feeding> feedingList = feedingService.viewFeedingList(watertank);
        System.out.println("feedingList = " + feedingList);

        return feedingList;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String receiveFeeding(@RequestBody Feeding feeding) {
        feedingService.receiveFeeding(feeding);

        Gson gson = new Gson();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code", "200");
        jsonObject.addProperty("message", "null");

        return gson.toJson(jsonObject);
    }
}
