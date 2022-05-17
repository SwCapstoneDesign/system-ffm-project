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
        return new ModelAndView("admin/loginForm");
    }

    @PostMapping("/login")
    public ModelAndView loginForm(Admin admin,
                                  Errors errors,
                                  HttpSession httpSession) {
        new AdminValidator().validate(admin, errors);
        ModelAndView mav = new ModelAndView();

        if (errors.hasErrors()) {
            mav.addObject("errorMsg", "입력된 값이 없습니다.");
            mav.setViewName("redirect:/login");
        }

        if (adminService.login(admin)) {
            httpSession.setAttribute("id", admin.getId());
            mav.setViewName("redirect:/Watertank/main");
        } else {
            mav.setViewName("redirect:/login");
        }

        return mav;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession httpSession) {
        httpSession.invalidate();
        return new ModelAndView("redirect:/login");
    }
}
