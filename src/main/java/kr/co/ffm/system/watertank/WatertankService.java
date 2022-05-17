package kr.co.ffm.system.watertank;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

@Service
public interface WatertankService {
    public List<WatertankViewInfo> viewWatertankList(Watertank watertank);
    public Watertank viewWatertank(Watertank watertank);
    public void editWatertank(Watertank watertank);
    public void receiveWatertank(Watertank watertank);
}
