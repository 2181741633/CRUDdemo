package net.s.anli2.controller;

import net.s.anli2.common.entity.Admin;
import net.s.anli2.common.utils.IdGenerator;
import net.s.anli2.common.utils.Md5utils;
import net.s.anli2.service.AdminService;
import net.s.anli2.service.AdminServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/user")
public class AdminCtoller {

    private AdminService adminService;

    public AdminCtoller() {
        adminService = new AdminServiceImp();
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code"); //表单获取的
        String rand = (String) request.getSession().getAttribute("rand"); //session
        if (!(code != null && code.trim().equalsIgnoreCase(rand))) {
            request.setAttribute("msg", "验证码错误，请重新输入！");
            return "WEB-INF/page/login";
        }

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String pwd = Md5utils.md5(password + name);
        Admin admin = adminService.findAdminNyName(name);

        boolean isSuccess = false;
        String msg = null;
        if (admin != null) {
            String psd = admin.getPassword();
            if (psd.equals(pwd)) {
                isSuccess = true;
            } else {
                isSuccess = false;
                msg = "密码错误!";
            }
        } else {
            isSuccess = false;
            msg = "用户名不存在!";
        }

        if (isSuccess) {
            request.getSession().setAttribute("user", admin);
            return "WEB-INF/page/main";
        } else {
            request.setAttribute("msg", msg);
            return "WEB-INF/page/login";
        }
    }

    @RequestMapping("/zhuce")
    public String zhuce(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String user = request.getParameter("user");
        String psd = request.getParameter("psd");

        Admin admin = new Admin(IdGenerator.getId(), user, Md5utils.md5(psd));
        Admin adminNyName = adminService.findAdminNyName(user);

        boolean isSuccess = false;
        String msg = null;


        if (adminNyName != null) {
            isSuccess = false;
            msg = "用户已经存在!!";
        } else {
            int i = adminService.addAdmin(admin);
            if (i > 0) {
                isSuccess = true;
                msg = "注册成功";
            } else {
                isSuccess = false;
                msg = "注册失败，重新来过！";
            }
        }

        if (isSuccess) {
            request.setAttribute("msg", msg);
            return "zhuce";
        } else {
            request.setAttribute("msg", msg);
            request.getSession().invalidate();
            return "zhuce";
        }
    }

    @RequestMapping("/loginout")
    public String loginout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return "index ";
    }
}
