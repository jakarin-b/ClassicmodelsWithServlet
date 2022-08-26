package sit.int202.classicmodelweb.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AdminFilter",
        servletNames = {"AdminPage1Servlet"})

public class AdminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)request).getSession();

        if(session == null || session.getAttribute("user")== null){
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED,"Please login first");
        }else if( session.getAttribute("role").toString() != "admin"){
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        else {
            chain.doFilter(request, response);

        }
    }
}

