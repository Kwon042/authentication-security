//package com.example.authentication_security.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@RequiredArgsConstructor
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        // Authorization 헤더에서 JWT 토큰 추출
//        String token = request.getHeader("Authorization");
//
//        if (token != null && token.startsWith("Bearer ")) {
//            token = token.substring(7); // "Bearer " 부분을 제거하고 JWT 토큰만 추출
//            if (jwtTokenProvider.validateToken(token)) {
//                // 토큰이 유효하면 인증 정보를 SecurityContext에 설정
//                Authentication authentication = jwtTokenProvider.getAuthentication(token);
//
//                if (authentication != null) {
//                    // 인증된 사용자 정보를 SecurityContext에 설정
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        }
//
//        filterChain.doFilter(request, response); // 다음 필터로 진행
//    }
//}
