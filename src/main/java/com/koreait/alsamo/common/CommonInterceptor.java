package com.koreait.alsamo.common;

import com.koreait.alsamo.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommonInterceptor implements HandlerInterceptor {

    @Autowired
    HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserEntity loginUser = (UserEntity) request.getSession().getAttribute("loginUser");
        if(loginUser != null && loginUser.getAuthno() == 5) {
            request.setAttribute("Msg","차단된 계정입니다. 관리자에게 문의하세요.");
            request.getRequestDispatcher("/user/loginErr").forward(request, response);
            return false;
        } else if (loginUser != null && loginUser.getAuthno() == 4) {
            request.setAttribute("Msg","미인증 계정입니다. 메일 인증을 해주세요.");
            request.getRequestDispatcher("/user/loginErr").forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
