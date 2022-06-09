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

    @Scheduled(initialDelay = 1000 * 65, fixedDelay = 1000 * 60)
    public void autoSendData() {

        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formatedNow = now.format(formatter);

        List<Watertank> list = watertankMapper.selectAll(new Watertank());

        FarmedFish farmedFish = null;
        for (Watertank watertank : list) {
            farmedFish = new FarmedFish();
            farmedFish.setNo(watertank.getFarmedFishNo());

            FarmedFishMapper farmedFishMapper = ApplicationContextProvider.getBean(FarmedFishMapper.class);
            FarmedFish selectedFish = farmedFishMapper.selectByNo(farmedFish);
            log.info(farmedFishMapper.selectByNo(farmedFish));
            String[] feedingTimes = selectedFish.getFeedingTime().split(",");
            for (String time : feedingTimes) {
                if (time.equals(formatedNow)) {
                    feedingService.sendFeeding(watertank);
                }
            }
        }

    }
}
