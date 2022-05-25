package kr.co.ffm.system.control;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/control")
public class ControlController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendWatertankControl(@RequestBody Control control) {

    }
}
