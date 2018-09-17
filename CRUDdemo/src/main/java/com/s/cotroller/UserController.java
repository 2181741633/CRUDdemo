package com.s.cotroller;

import com.s.entity.Dept;
import com.s.entity.User;
import com.s.service.DeptService;
import com.s.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    DeptService deptService;
    @Autowired
    UserService userService;

    @RequestMapping("/depts")
    @ResponseBody
    public List<Dept> getDepts() {
        List<Dept> list = deptService.getDepts();
        return list;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public void addUser(User user, HttpServletResponse response) {
        userService.addUser(user);
        try {
            response.getWriter().print("ok");
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/findcf")
    @ResponseBody
    public String findchong(@RequestParam("uName") String uName) {
        boolean flag = userService.selectchong(uName);
        if (flag) {
            return "ok";
        } else {
            return "no";
        }
    }

    @RequestMapping(value = "/uname/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User findUser(@PathVariable("id") Integer id) {
        User user = userService.findUser(id);
        return user;
    }

    @RequestMapping(value = "/update/{uId}", method = RequestMethod.PUT)
    @ResponseBody
    public void UpdateUser(User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/del/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public void DelUser(@PathVariable("ids") String ids) {
        List<Integer> list = new ArrayList<>();
        if (ids.contains("-")) {
            String[] str = ids.split("-");
            for (String s : str) {
                list.add(Integer.parseInt(s));
            }
            userService.deleteUsers(list);
        } else {
            int id = Integer.parseInt(ids);
            userService.deleteUser(id);
        }
    }
}
