package sit.int202.classicmodelweb.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "LoggerFilter",urlPatterns = "/*")
public class LoggerFilter implements Filter {

    private FilterConfig config;

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        long before = System.currentTimeMillis();
        chain.doFilter(request, response);
        long after = System.currentTimeMillis();
        HttpServletRequest req = (HttpServletRequest) request;
        String msg = req.getRequestURI() + "Duration :" + (after-before) + "ms.";
        config.getServletContext().log(msg);
    }

    public void destroy() {
    }
}
