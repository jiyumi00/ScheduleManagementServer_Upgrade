package com.sparta.ScheduleManagement_Upgrade.config.filter;

import com.sparta.ScheduleManagement_Upgrade.config.util.JWTUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JWTFilter implements Filter {
    private final JWTUtil jwtUtil;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse=(HttpServletResponse) servletResponse;

        String requestURI=httpRequest.getRequestURI();
        String username=null;
        String jwt=null;

        
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
