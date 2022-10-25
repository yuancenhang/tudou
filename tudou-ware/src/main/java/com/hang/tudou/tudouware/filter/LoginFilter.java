
package com.hang.tudou.tudouware.filter;

import com.alibaba.fastjson2.JSON;
import com.hang.tudou.tudouware.entity.R;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器，验证是否登陆的
 */

//注册名字，拦截的路径。要被扫描到创建对象才能生效，所以还需要在启动类上扫描
@WebFilter(filterName = "loginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    private static final AntPathMatcher bj = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String path = request.getRequestURI();
        String[] excludePath = {
                "/静态资源目录/**",
                "/user/login",
                "/user/loginout"};
        boolean ok = compare(path,excludePath);

        //ok为true，说明访问的是登陆相关，放行
        if (ok){
            filterChain.doFilter(request,servletResponse);
            return;
        }

        /*
        执行到此，说明不是访问登陆相关，判断是否登陆
         */
        String id = (String) request.getSession().getAttribute("你在登陆时存进去的值");
        if (id != null){
            filterChain.doFilter(request,servletResponse);
            return;
        }

        /*
        执行到此，说明是非法访问
         */
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }

    //封装的一个比较路径的方法，如果返回true，表示需要放行
    boolean compare(String path,String[] excludePath){
        for (String s : excludePath){
            if (bj.match(s,path)){
                return true;
            }
        }
        return false;
    }
}


