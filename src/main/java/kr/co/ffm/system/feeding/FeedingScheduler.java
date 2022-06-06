package kr.co.ffm.system.feeding;

import kr.co.ffm.system.farmedfish.FarmedFish;
import kr.co.ffm.system.farmedfish.FarmedFishMapper;
import kr.co.ffm.system.watertank.Watertank;
import kr.co.ffm.system.watertank.WatertankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class FeedingScheduler {
    @Autowired
    private WatertankMapper watertankMapper;
    @Autowired
    private FarmedFishMapper farmedFishMapper;
    @Autowired
    private FeedingService feedingService;
    @Autowired
    private FeedingMapper feedingMapper;
    private Map<String, List<String>> sendTarget;

    public FeedingScheduler() {
        List<Watertank> list = watertankMapper.selectAll(new Watertank());

        FarmedFish farmedFish = null;
        for (Watertank watertank : list) {
            farmedFish = new FarmedFish();
            farmedFish.setNo(watertank.getFarmedFishNo());
            FarmedFish selectedFish = farmedFishMapper.selectByNo(farmedFish);

            String[] feedingTimes = selectedFish.getFeedingTime().split(",");
            List<String> feedingTimeList = new ArrayList<>(Arrays.asList(feedingTimes));

            sendTarget.put(watertank.getId(), feedingTimeList);
        }
    }

    @Scheduled(initialDelay = 1000 * 65, fixedDelay = 1000 * 60)
    public void autoSendData() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formatedNow = now.format(formatter);

        Iterator<String> keys = sendTarget.keySet().iterator();
        String key = null;

        while (keys.hasNext()) {
            key = keys.next().toString();

            List<String> feedingTimes = sendTarget.get(key);
            for (String time : feedingTimes) {
                if (time.equals(formatedNow)) {
                    Watertank watertank = new Watertank();
                    watertank.setId(key);
                    feedingService.sendFeeding(watertank);
                }
            }
        }
    }
}
