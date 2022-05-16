package kr.co.ffm.system.watertank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

@Service
public class WatertankServiceImpl implements WatertankService {
    @Autowired
    private WatertankMapper watertankMapper;

    @Override
    public List<Mark> viewWatertankList(Watertank watertank) {
        return null;
    }

    @Override
    public Watertank viewWatertank(Watertank watertank) {
        return null;
    }

    @Override
    public void editWatertank(Watertank watertank) {

    }

    @Override
    public void receiveWatertank(Watertank watertank) {

    }
}
