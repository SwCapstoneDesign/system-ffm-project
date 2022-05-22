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
    private boolean adminMatch = true;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("admin/loginForm");
        mav.addObject("adminMatch", adminMatch);
        adminMatch = true;

        return mav;
    }

    @PostMapping("/login")
    public ModelAndView loginForm(Admin admin,
                                  Errors errors,
                                  HttpSession httpSession) {
        new AdminValidator().validate(admin, errors);
        ModelAndView mav = new ModelAndView("redirect:/login");

        if (adminMatch = !errors.hasErrors()){
            adminMatch = adminService.login(admin);
            if (adminMatch) {
                httpSession.setAttribute("login", admin);
                mav.setViewName("redirect:/watertank/main");
            }
        }

        return mav;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession httpSession) {
        httpSession.invalidate();
        return new ModelAndView("redirect:/login");
    }
}
