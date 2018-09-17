package net.s.anli1.controller;

import com.tosit.framework.mvc.annotation.RequestPath;
import net.s.anli1.common.entity.Admin;
import net.s.anli1.common.util.Md5utils;
import net.s.anli1.service.AdminService;
import net.s.anli1.service.AdminServiceimp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestPath("/user")
public class AdminController {

    private AdminService adminService;

    public AdminController() {
        this.adminService = new AdminServiceimp();
    }

    @RequestPath("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String md5 = Md5utils.md5(password + username);

        boolean isCg = false;
        Admin admin = adminService.findByname(username);

        String msg = null;
        if (admin != null) {
            String psd = admin.getPassword();
            if (psd.equals(md5)) {
                isCg = true;
            } else {
                isCg = false;
                msg = "密码错误!!!";
            }
        } else if (username == "") {
            isCg = false;
            msg = "用户名不为空!!!";
        } else {
            isCg = false;
            msg = "用户名不存在!!!";
        }

        if (isCg) {
            request.getSession().setAttribute("user", admin);
            return "/WEB-INF/page/tableindex.jsp";
        } else {
            request.setAttribute("msg", msg);
            return "/index.jsp";
        }
    }

    @RequestPath("/zhuce")
    public String zhuce(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("user");
        String psd = request.getParameter("psd");
        Admin admin = new Admin(user, psd);

        int i = adminService.insertAdmin(admin);
        boolean isSuccess = true;
        String msg = null;
        if (i > 0) {
            if (admin.getUsername().equals(user)) {
                isSuccess = false;
                msg = "用户名已经被占用!!!";
            } else {
                isSuccess = true;
                msg = "注册成功!!!";
            }
        } else {
            isSuccess = false;
            msg = "注册失败!!!";
        }
        if (isSuccess) {
            request.setAttribute("msg", msg);
            return "/zhuce.jsp";
        } else {
            request.getSession().setAttribute("user", admin);
            request.setAttribute("msg", msg);
            return "/zhuce.jsp";
        }
    }

    @RequestPath("/loginout")
    public String loginout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return "/index.jsp";
    }
}
