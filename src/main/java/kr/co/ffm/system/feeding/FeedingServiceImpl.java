package kr.co.ffm.system.feeding;

import kr.co.ffm.system.watertank.Watertank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedingServiceImpl implements FeedingService {

    @Autowired
    private FeedingMapper feedingMapper;

    @Override
    public List<Feeding> viewFeedingList(Watertank watertank) {
        return null;
    }

    @Override
    public void receiveFeeding(Feeding feeding) {

    }
}
