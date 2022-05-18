package kr.co.ffm.system.farmedfish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmedFishServiceImpl implements FarmedFishService {

    @Autowired
    private FarmedFishMapper farmedFishMapper;

    @Override
    public void registFarmedFish(FarmedFish farmedFish) {
        farmedFishMapper.insert(farmedFish);
    }

    @Override
    public List<FarmedFish> viewFarmedFishList(FarmedFish farmedFish) {
        return farmedFishMapper.selectAll(farmedFish);
    }

    @Override
    public FarmedFish viewFarmedFish(FarmedFish farmedFish) {
        return farmedFishMapper.selectByNo(farmedFish);
    }

    @Override
    public void editFarmedFish(FarmedFish farmedFish) {
        farmedFishMapper.updateByNo(farmedFish);
    }
}
