package kr.co.ffm.system.control;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/control")
public class ControlController {
    @PostMapping
    public void sendWatertankControl(Control control) {

    }
}
