package kr.co.ffm.system.watertankstatus;

import kr.co.ffm.system.watertank.Watertank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatertankStatusServiceImpl implements WatertankStatusService {
    @Autowired
    private WatertankStatusMapper watertankStatusMapper;

    @Override
    public List<WatertankStatus> viewWatertankStatusList(Watertank watertank) {
        return null;
    }

    @Override
    public void receiveWatertankStatus(WatertankStatus watertankStatus) {

    }
}
