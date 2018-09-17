package com.s.cotroller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.s.entity.User;
import com.s.service.PageServert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    PageServert pageServert;


    @RequestMapping("/page")
    public String PageAll(@RequestParam(value = "pageno", defaultValue = "1") Integer page, HttpServletRequest request) {

        PageHelper.startPage(page, 10);
        List<User> deptMapperList = pageServert.findAll();
        PageInfo pageInfo = new PageInfo(deptMapperList);
        request.setAttribute("pageinfo", pageInfo);
        return "zhu";
    }
}
