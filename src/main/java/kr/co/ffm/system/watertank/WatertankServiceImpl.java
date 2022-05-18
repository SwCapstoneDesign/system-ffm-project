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

            List<WatertankStatus> statusList = watertankStatusMapper.selectAllByWatertankId(watertankViewInfo);
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
        if (watertankMapper.selectById(watertank) == null) {
            watertankMapper.insert(watertank);
        }
    }
}
