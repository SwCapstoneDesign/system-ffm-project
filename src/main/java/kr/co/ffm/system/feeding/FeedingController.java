package kr.co.ffm.system.feeding;

import kr.co.ffm.system.farmedfish.FarmedFish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feeding")
public class FeedingController {
    @Autowired
    private FeedingService feedingService;

    @PostMapping(value = "/{no}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String feedingList(FarmedFish farmedFish) {
        return null;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String receiveFeeding(Feeding feeding) {
        return null;
    }
}
