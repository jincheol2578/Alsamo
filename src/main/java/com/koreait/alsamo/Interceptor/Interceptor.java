package com.koreait.alsamo.Interceptor;


import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") != null) {
            session.removeAttribute("loginUser");
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        Object user = modelAndView.getModelMap().get("loginUser");
        if (user != null) {
            session.setAttribute("loginUser",user);

            Cookie loginCookie = new Cookie("loginCookie",session.getId());
            loginCookie.setPath("/");
            loginCookie.setMaxAge(7*24*60*60);

            response.addCookie(loginCookie);
        } else {
            response.sendRedirect("/loginErr?err=0");
        }
    }
}
