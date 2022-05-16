package kr.co.ffm.system.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public ModelAndView login() {
//        view : loginForm
        return null;
    }

    @PostMapping("/login")
    public ModelAndView loginForm(Admin admin,
                                  Errors errors,
                                  HttpSession httpSession) {
//        redirect : /Watertank/main
        return null;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession httpSession) {
//        redirect : /login
        return null;
    }
}
