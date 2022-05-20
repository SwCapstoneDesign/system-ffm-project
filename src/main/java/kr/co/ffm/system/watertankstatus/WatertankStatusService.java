package kr.co.ffm.system.watertankstatus;

import kr.co.ffm.system.watertank.Watertank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WatertankStatusService {
    public List<WatertankStatus> viewWatertankStatusList(WatertankStatus watertankStatus);
    public void receiveWatertankStatus(WatertankStatus watertankStatus);
}

