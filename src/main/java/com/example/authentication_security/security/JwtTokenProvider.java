//package com.example.authentication_security.security;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtTokenProvider {
//
//    private final String SECRET_KEY = "yourSecretKey"; // 실제 비밀 키를 환경 변수나 config 파일에서 관리하는 것이 좋습니다.
//    private final long validityInMilliseconds = 3600000;  // 1시간
//
//    public String generateToken(Authentication authentication) {
//        Claims claims = Jwts.claims().setSubject(authentication.getName());
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + validityInMilliseconds);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(validity)
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false; // 토큰이 유효하지 않으면 false 반환
//        }
//    }
//
//    public Authentication getAuthentication(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//
//        // 사용자 정보 가져오기 (이 예시에서는 username만 사용)
//        String username = claims.getSubject();
//
//        if (username != null) {
//            // 인증 객체 반환
//            return new UsernamePasswordAuthenticationToken(username, null, null);
//        }
//
//        return null; // 인증 정보가 없으면 null 반환
//    }
//}
