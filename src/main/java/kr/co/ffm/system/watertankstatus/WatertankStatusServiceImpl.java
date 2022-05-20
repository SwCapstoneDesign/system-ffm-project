package kr.co.ffm.system.watertankstatus;

import kr.co.ffm.system.farmedfish.FarmedFish;
import kr.co.ffm.system.farmedfish.FarmedFishMapper;
import kr.co.ffm.system.watertank.Watertank;
import kr.co.ffm.system.watertank.WatertankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatertankStatusServiceImpl implements WatertankStatusService {
    @Autowired
    private WatertankStatusMapper watertankStatusMapper;
    @Autowired
    private WatertankMapper watertankMapper;
    @Autowired
    private FarmedFishMapper farmedFishMapper;

    @Override
    public List<WatertankStatus> viewWatertankStatusList(WatertankStatus watertankStatus) {
        return watertankStatusMapper.selectAllByWatertankId(watertankStatus);
    }

    @Override
    public void receiveWatertankStatus(WatertankStatus watertankStatus) {
        Watertank watertank = new Watertank();
        watertank.setId(watertankStatus.getWatertankId());

        Watertank selectedWartertank = watertankMapper.selectById(watertank);
        if (selectedWartertank.getId().equals(watertankStatus.getWatertankId())) {
            watertankStatusMapper.insert(watertankStatus);

            FarmedFish farmedFish = new FarmedFish();
            farmedFish.setNo(watertank.getFarmedFishNo());
            farmedFish = farmedFishMapper.selectByNo(farmedFish);

            if (farmedFish.getTemperature() != watertankStatus.getTemperature()) {
                //난세랑 회의
            }
        }
    }
}
