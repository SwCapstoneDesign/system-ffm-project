package kr.co.ffm.system.feeding;

import kr.co.ffm.system.watertank.Watertank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedingService {
    public List<Feeding> viewFeedingList(Watertank watertank);
    public void receiveFeeding(Feeding feeding);
    public String sendFeeding(Watertank watertank);
}