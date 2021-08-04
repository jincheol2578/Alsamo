package com.koreait.alsamo.common;

import com.koreait.alsamo.user.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserEntity loginUser = (UserEntity) request.getSession().getAttribute("loginUser");
        System.out.println(loginUser);
        if(loginUser != null && loginUser.getAuthno() == 5) {
            request.setAttribute("Msg","차단된 계정입니다. 관리자에게 문의하세요.");
            response.sendRedirect("/user/errorMsg");
            return false;
        } else if (loginUser != null && loginUser.getAuthno() == 5) {
            request.setAttribute("Msg","미인증 계정입니다. 메일 인증을 해주세요.");
            response.sendRedirect("/user/errorMsg");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after");
    }
}
