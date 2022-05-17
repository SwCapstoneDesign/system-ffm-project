package kr.co.ffm.system.watertankstatus;

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

    @Override
    public WatertankStatus viewWatertankStatusList(Watertank watertank) {
        return watertankStatusMapper.selectByWatertankId(watertank);
    }

    @Override
    public void receiveWatertankStatus(WatertankStatus watertankStatus) {
        Watertank watertank = new Watertank();
        watertank.setId(watertankStatus.getWatertankId());
        if (watertankMapper.selectById(watertank) != null) {
            //양식어 정보 조회 하기 추가한뒤 비교문 작성하기
        }
    }
}
