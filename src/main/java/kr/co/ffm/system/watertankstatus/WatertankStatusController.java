package kr.co.ffm.system.watertankstatus;

import kr.co.ffm.system.watertank.Watertank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WatertankStatusController {
    @Autowired
    private WatertankStatusService watertankStatusService;

    @PostMapping
    public String watertankStatusList(Watertank watertank) {
        return null;
    }

    public String receiveWatertankStatus(WatertankStatus watertankStatus) {
        return null;
    }
}
