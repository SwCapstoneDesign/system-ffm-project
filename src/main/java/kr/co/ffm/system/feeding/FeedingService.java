package kr.co.ffm.system.feeding;

import kr.co.ffm.system.watertank.Watertank;

import java.util.List;

public interface FeedingService {
    public List<Feeding> viewFeedingList(Watertank watertank);
    public void receiveFeeding(Feeding feeding);
}