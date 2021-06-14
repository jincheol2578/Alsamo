package com.koreait.alsamo.user;

import org.omg.CORBA.Request;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.Arrays;

public class AuthCheckIntercepter implements HandlerInterceptor {
    //관리하고 싶은 주소값들의 배열
//    private String[] needLoginUriArr={"/board/writeMod", "/board/favList","/user/profile"};

    //Controller로 보내기 전에 처리(아에못들어가 가게 처리 하려면 여기서)
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    //Controller의 handler가 끝나면 처리 (화면열기 직전, 화면열기 직전이라 원하는 화면으로 이동 가능 ) , ModelAndView modelAndView 여부 판단
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        System.out.println(uri);

        // uri값이 needLoginUriArr안에 있는지 물어본다 있으면 관리대상 없으면 통과
//    if(Arrays.asList(needLoginUriArr).contains(uri)){
        UserEntity loginUser = (UserEntity) httpServletRequest.getSession().getAttribute("loginUser");
        if (loginUser == null) {
//            modelAndView.getViewName(); 원래가야할 주소값
           modelAndView.setViewName("/user/needLogin");
        }
//    }

    }

    //화면(view)이 아예 다만들어진 이후
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
