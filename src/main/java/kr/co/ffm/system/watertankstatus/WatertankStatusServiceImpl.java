package kr.co.ffm.system.watertankstatus;

import kr.co.ffm.system.control.Control;
import kr.co.ffm.system.control.ControlService;
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
    @Autowired
    private ControlService controlService;

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
                Control control = new Control();
                if(watertankStatus.getTemperature() < farmedFish.getTemperature()) {
                    control.setControl("H");
                } else {
                    control.setControl("P");
                }
                control.setTarget("T");
                control.setValue(farmedFish.getTemperature());
                controlService.sendControl(watertank, control);
            }

            if (farmedFish.getPh() != watertankStatus.getPh()) {
                Control control = new Control();
                control.setControl("P");
                control.setTarget("P");
                control.setValue(farmedFish.getPh());
                controlService.sendControl(watertank, control);
            }

            if (farmedFish.getOxygen() != watertankStatus.getOxygen()) {
                Control control = new Control();
                control.setControl("P");
                control.setTarget("O");
                control.setValue(farmedFish.getOxygen());
                controlService.sendControl(watertank, control);
            }
        }
    }
}
