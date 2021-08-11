package com.koreait.alsamo.common;

import com.koreait.alsamo.user.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserEntity loginAdmin = (UserEntity) request.getSession().getAttribute("loginAdmin");
        if (loginAdmin != null && (loginAdmin.getAuthno() == 1 || loginAdmin.getAuthno() == 2)) {
            return true;
        }
        response.sendRedirect("/admin/login");
        return false;
    }

}
