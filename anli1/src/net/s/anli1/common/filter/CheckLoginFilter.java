package net.s.anli1.common.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*@WebFilter("*.do")*/
public class CheckLoginFilter implements Filter {
    private String ignorePath;
    private String[] allPath;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String ignore = filterConfig.getInitParameter("ignore");
        this.ignorePath=ignore;
        if (ignorePath!=null){
            allPath = ignorePath.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest request = (HttpServletRequest) servletRequest;

       boolean isPase = false;
        for (String str:allPath) {
            if (request.getRequestURI().indexOf(str.trim())==-1){
                isPase = true;
                break;
            }
        }
       if (isPase){
           filterChain.doFilter(servletRequest,servletResponse);
       }else {
           if (request.getSession().getAttribute("user")!=null){
               filterChain.doFilter(servletRequest,servletResponse);
           }else {
               request.getRequestDispatcher("/index.jsp").forward(request,servletResponse);
               request.setAttribute("msg","登陆后执行操作！");
           }
       }
    }

    @Override
    public void destroy() {

    }
}
