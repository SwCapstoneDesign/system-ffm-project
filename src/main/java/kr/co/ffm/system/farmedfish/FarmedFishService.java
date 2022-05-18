package kr.co.ffm.system.farmedfish;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FarmedFishService {
    public void registFarmedFish(FarmedFish farmedFish);
    public List<FarmedFish> viewFarmedFishList(FarmedFish farmedFish);
    public FarmedFish viewFarmedFish(FarmedFish farmedFish);
    public void editFarmedFish(FarmedFish farmedFish);
}
