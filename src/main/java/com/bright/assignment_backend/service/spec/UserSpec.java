package com.bright.assignment_backend.service.spec;

import lombok.Data;
import lombok.experimental.Accessors;

public class UserSpec {
    @Data
    @Accessors(chain = true)
    public static class RegisterReq{
        private String name;
        private String email;
        private String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
    @Data
    @Accessors(chain = true)
    public static class RegisterRes{
        private String message;
        //private String token;


        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
