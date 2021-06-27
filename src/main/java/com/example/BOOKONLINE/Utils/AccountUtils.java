package com.example.BOOKONLINE.Utils;

public class AccountUtils {
    public static boolean checkLogin(String email, String pwd) {
        return email.equals(CONSTANT.ADMIN_EMAIL) && pwd.equals(CONSTANT.ADMIN_PWD);
    }
}
