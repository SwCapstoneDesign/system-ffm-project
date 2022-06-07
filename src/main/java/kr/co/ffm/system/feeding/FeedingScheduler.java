package kr.co.ffm.system.feeding;

import kr.co.ffm.system.config.ApplicationContextProvider;
import kr.co.ffm.system.farmedfish.FarmedFish;
import kr.co.ffm.system.farmedfish.FarmedFishMapper;
import kr.co.ffm.system.watertank.Watertank;
import kr.co.ffm.system.watertank.WatertankMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Log4j2
public class FeedingScheduler {
    @Autowired
    private WatertankMapper watertankMapper;
    @Autowired
    private FarmedFishMapper farmedFishMapper;
    @Autowired
    private FeedingService feedingService;
//    @Autowired
//    private FeedingMapper feedingMapper;
//    private Map<String, List<String>> sendTarget;
//
//
//    public FeedingScheduler() {
//        List<Watertank> list = watertankMapper.selectAll(new Watertank());
//
//        FarmedFish farmedFish = null;
//        for (Watertank watertank : list) {
//            farmedFish = new FarmedFish();
//            farmedFish.setNo(watertank.getFarmedFishNo());
//            FarmedFish selectedFish = farmedFishMapper.selectByNo(farmedFish);
//
//            String[] feedingTimes = selectedFish.getFeedingTime().split(",");
//            List<String> feedingTimeList = new ArrayList<>(Arrays.asList(feedingTimes));
//
//            sendTarget.put(watertank.getId(), feedingTimeList);
//        }
//    }

    @Scheduled(initialDelay = 1000 * 1, fixedDelay = 1000 * 10)
    public void autoSendData() {
        log.info("작동중");

        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formatedNow = now.format(formatter);

        List<Watertank> list = watertankMapper.selectAll(new Watertank());

        FarmedFish farmedFish = null;
        for (Watertank watertank : list) {
            log.info("테스트");
            farmedFish = new FarmedFish();
            log.info(watertank);
            farmedFish.setNo(watertank.getFarmedFishNo());

            FarmedFishMapper farmedFishMapper = ApplicationContextProvider.getBean(FarmedFishMapper.class);
            FarmedFish selectedFish = farmedFishMapper.selectByNo(farmedFish);
            log.info(farmedFishMapper.selectByNo(farmedFish));
            String[] feedingTimes = selectedFish.getFeedingTime().split(",");
            for (String time : feedingTimes) {
                if (time.equals(formatedNow)) {
                    log.info("--밥줌--");
                    feedingService.sendFeeding(watertank);
                }
                log.info("--안줌--");
            }
        }

    }
}
