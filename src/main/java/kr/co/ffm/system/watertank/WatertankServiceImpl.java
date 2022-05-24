package kr.co.ffm.system.watertank;

import kr.co.ffm.system.farmedfish.FarmedFish;
import kr.co.ffm.system.farmedfish.FarmedFishMapper;
import kr.co.ffm.system.watertankstatus.WatertankStatus;
import kr.co.ffm.system.watertankstatus.WatertankStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WatertankServiceImpl implements WatertankService {
    @Autowired
    private WatertankMapper watertankMapper;
    @Autowired
    private WatertankStatusMapper watertankStatusMapper;
    @Autowired
    private FarmedFishMapper farmedFishMapper;

    @Override
    public List<WatertankViewInfo> viewWatertankList(Watertank watertank) {
        List<Watertank> watertankList = watertankMapper.selectAll(watertank);

        List<WatertankViewInfo> infoList = new ArrayList<>();
        for (int i = 0; i < watertankList.size(); i++) {
            WatertankViewInfo watertankViewInfo = new WatertankViewInfo();
            watertankViewInfo.setId(watertankList.get(i).getId());
            watertankViewInfo.setFarmedFishNo(watertankList.get(i).getFarmedFishNo());
            watertankViewInfo.setFarmedFishName(watertankList.get(i).getFarmedFishName());
            watertankViewInfo.setAgentIpAddress(watertankList.get(i).getAgentIpAddress());
            watertankViewInfo.setRegistDate(watertankList.get(i).getRegistDate());
            watertankViewInfo.setActive(watertankList.get(i).getActive());

            WatertankStatus status = new WatertankStatus();
            status.setWatertankId(watertankList.get(i).getId());

            List<WatertankStatus> statusList = watertankStatusMapper.selectAllByWatertankId(status);
            watertankViewInfo.setStatusList(statusList);

            infoList.add(watertankViewInfo);
        }
        return infoList;
    }

    @Override
    public Watertank viewWatertank(Watertank watertank) {
        return watertankMapper.selectById(watertank);
    }

    @Override
    public void editWatertank(Watertank watertank) {
        watertankMapper.updateById(watertank);
    }

    @Override
    public void receiveWatertank(Watertank watertank) {
        Watertank selectedWatertank = watertankMapper.selectById(watertank);
        if (selectedWatertank == null) {
            FarmedFish farmedFish = new FarmedFish();
            farmedFish.setNo(watertank.getFarmedFishNo());

            FarmedFish selectedFish = farmedFishMapper.selectByNo(farmedFish);

            watertank.setFarmedFishName(selectedFish.getName());
            watertankMapper.insert(watertank);
        }
    }
}
