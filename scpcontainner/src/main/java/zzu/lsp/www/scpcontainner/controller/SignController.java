package zzu.lsp.www.scpcontainner.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zzu.lsp.www.scpcontainner.javabean.User;
import zzu.lsp.www.scpcontainner.service.UserService;

@RestController
public class SignController {
    private final UserService userService;

    public SignController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public SignResponse signup(@RequestBody SignRequest signRequest) {
        try {
            // 添加输入验证
            if (signRequest.getUsername() == null || signRequest.getUsername().trim().isEmpty()) {
                return new SignResponse(false, "用户名不能为空");
            }

            if (signRequest.getPassword() == null || signRequest.getPassword().trim().isEmpty()) {
                return new SignResponse(false, "密码不能为空");
            }

            User user = new User(null, signRequest.getUsername(), signRequest.getPassword(),"1");
            boolean result = userService.save(user);

            if (result) {
                return new SignResponse(true, "注册成功");
            } else {
                return new SignResponse(false, "注册失败：用户名可能已存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new SignResponse(false, "系统错误：" + e.getMessage());
        }
    }

    @Data
    public static class SignRequest {
        private String username;
        private String password;
        private String clearance;
    }

    @Data
    public static class SignResponse {
        private boolean success;
        private String message;

        public SignResponse(boolean success, String message) {
            this.success = success;
            this.message = message;
        }
    }
}

