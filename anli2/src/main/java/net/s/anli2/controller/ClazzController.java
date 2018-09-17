package net.s.anli2.controller;

import net.s.anli2.common.entity.Clazz;
import net.s.anli2.common.utils.IdGenerator;
import net.s.anli2.common.utils.Pager;
import net.s.anli2.dao.ClazzDao;
import net.s.anli2.service.ClazzService;
import net.s.anli2.service.ClazzServiceimp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("clazz")
public class ClazzController {

    public ClazzService clazzService;

    public ClazzController() {
        this.clazzService = new ClazzServiceimp();
    }

    @RequestMapping("/select")
    public String select(HttpServletRequest request, HttpServletResponse response) {
        String pageNo = request.getParameter("PageNo");
        if (pageNo == null) {
            pageNo = "1";
        }
        String pageSize = request.getParameter("PageSize");
        if (pageSize == null) {
            pageSize = "8";
        }

        int pageNum = Integer.parseInt(pageNo);
        int pageSiz = Integer.parseInt(pageSize);


        Pager<Clazz> clazzPager = clazzService.findByPage(pageNum, pageSiz);
        request.setAttribute("clazzPage", clazzPager);

        /*List<Clazz> allClazz = clazzService.findAllClazz();
        request.setAttribute("allClazz", allClazz);*/
        return "WEB-INF/page/tableindex";
    }

    @RequestMapping("/add")
    public void add(HttpServletRequest request, HttpServletResponse response) {
        String clazzNmae = request.getParameter("clazzName");
        String teacherName = request.getParameter("teacherName");
        Clazz clazz = new Clazz(IdGenerator.getId(), clazzNmae, teacherName, 0, new Date());
        clazzService.addClazz(clazz);

        try {
            response.getWriter().print("ok");
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/del")
    public void del(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        clazzService.removeClazz(id);

        try {
            response.getWriter().print("ok");
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/dels")
    @ResponseBody
    public void dels(@RequestParam("arr[]") String[] arr,HttpServletResponse response) {
          ClazzServiceimp csi = new ClazzServiceimp();
          csi.removeClazz(arr);

        try {
            response.getWriter().print("ok");
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


