package kr.co.ffm.system.control;

import kr.co.ffm.system.watertank.Watertank;
import org.springframework.stereotype.Service;

@Service
public interface ControlService {
    public String sendControl(Watertank watertank, Control control);
}
