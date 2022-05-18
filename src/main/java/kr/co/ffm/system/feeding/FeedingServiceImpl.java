package kr.co.ffm.system.feeding;

import kr.co.ffm.system.watertank.Watertank;
import kr.co.ffm.system.watertank.WatertankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedingServiceImpl implements FeedingService {

    @Autowired
    private FeedingMapper feedingMapper;
    @Autowired
    private WatertankMapper watertankMapper;

    @Override
    public List<Feeding> viewFeedingList(Watertank watertank) {
        return feedingMapper.selectAll(watertank);
    }

    @Override
    public void receiveFeeding(Feeding feeding) {
        Watertank watertank = new Watertank();
        watertank.setId(feeding.getWaterTankId());

        if (watertankMapper.selectById(watertank) != null) {
            feedingMapper.insert(feeding);
        }
    }
}
