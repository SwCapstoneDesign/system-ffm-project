package kr.co.ffm.system.feeding;

import kr.co.ffm.system.farmedfish.FarmedFish;
import kr.co.ffm.system.watertank.Watertank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feeding")
public class FeedingController {
    @Autowired
    private FeedingService feedingService;

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Feeding> feedingList(@RequestBody Watertank watertank) {
        List<Feeding> feedingList = feedingService.viewFeedingList(watertank);

        return feedingList;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String receiveFeeding(@RequestBody Feeding feeding) {
        feedingService.receiveFeeding(feeding);
        return null;
    }
}
