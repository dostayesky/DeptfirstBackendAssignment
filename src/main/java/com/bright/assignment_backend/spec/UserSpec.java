package com.bright.assignment_backend.spec;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

public class UserSpec {
    @Data
    @Accessors(chain = true)
    public static class RegisterReq{
        @NotBlank
        private String name;
        @NotBlank
        private String email;
        @NotBlank
        private String password;
    }
    @Data
    @Accessors(chain = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class RegisterRes{

        private String message;
        @JsonIgnore
        private Boolean success;
    }

    @Data
    @Accessors(chain = true)
    public static class LoginReq{
        @NotBlank
        private String email;
        @NotBlank
        private String password;
    }

    @Data
    @Accessors(chain = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class LoginRes{
        private String token;
        @JsonIgnore
        private Boolean success;
        private String message;
    }

    @Data
    @Accessors(chain = true)
    public static class GetProfileRes{
        private long id;
        private String name;
        private String email;
        @JsonIgnore
        private Boolean success = true;

    }

    @Data
    @Accessors(chain = true)
    public static class GetProfileReq {
        private String email;
    }

    @Data
    @Accessors(chain = true)
    public static class LogOutRes{
        private String token ="";
        @JsonIgnore
        private Boolean success = true;
    }
}
