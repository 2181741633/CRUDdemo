package net.s.anli2.common.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class CheckLoginFilter implements Filter {
    private String ignorePath;
    private String[] allPath;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String ignore = filterConfig.getInitParameter("ignore");
        this.ignorePath = ignore;
        if (ignorePath != null) {
            allPath = ignorePath.trim().split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        boolean isPase = false;

        for (String str : allPath) {
            if (request.getRequestURI().indexOf(str.trim()) != -1) {
                isPase = true;
                break;
            }
        }
        isPase = true;
        if (isPase) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (request.getSession().getAttribute("user") != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                request.setAttribute("msg", "请登陆后再操作");
                request.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(request, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
