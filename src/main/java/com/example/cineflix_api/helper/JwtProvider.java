package com.example.cineflix_api.helper;

import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    // Khai báo hàm tạo token
    // Giải mã token
    // Kiểm tra token có phải do hệ thống sinh ra hay không

    private String SECRET_KEY = "YWRtaW4xMjM0NTY3ODkwQGFkbWluMTIzNDU2Nzg5MEBhZG1pbjEyMzQ1Njc4OTA=";
    private long JWT_EXPIRED = 8 * 60 * 60 * 1000;
    private Gson gson = new Gson();

    public String generateToken(String data){
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + JWT_EXPIRED);

//        String json = gson.toJson(user);

        return Jwts.builder()
                .setSubject(data) // Dữ liệu muốn lưu kèm ở Token
                .setIssuedAt(now)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Thuật mã hóa và mã hóa
                .compact();
    }

    public String decodeToken(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY) // Key mã hóa token ban đầu
                .parseClaimsJws(token) // Truyền tham số token cần mã hóa
                .getBody()
                .getSubject(); // Lấy giá trị
    }

    public boolean validationToken(String token){
        try{
            Jwts.parser()
                    .setSigningKey(SECRET_KEY) // Key mã hóa token ban đầu
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
