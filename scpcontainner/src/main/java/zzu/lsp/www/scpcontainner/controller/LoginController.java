package zzu.lsp.www.scpcontainner.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zzu.lsp.www.scpcontainner.javabean.User;
import zzu.lsp.www.scpcontainner.service.UserService;

@RestController
public class LoginController {
    public static User user;
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    // 处理登录请求
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        try {
            user = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
            if (user != null) {
                return new LoginResponse(true, "登录成功", user);
            } else {
                return new LoginResponse(false, "用户名或密码错误", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new LoginResponse(false, "系统错误", null);
        }
    }

    // 登录请求数据类
    @Setter
    @Getter
    public static class LoginRequest {
        // Getter和Setter
        private String username;
        private String password;

    }

    // 登录响应数据类
    @Setter
    @Getter
    public static class LoginResponse {
        // Getter和Setter
        private boolean success;
        private String message;
        private User user;

        public LoginResponse(boolean success, String message, User user) {
            this.success = success;
            this.message = message;
            this.user = user;
        }

    }
}

