package StringClass;

import java.util.Scanner;

public class login {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 注册的账号密码
        String username = "hehewocao";
        String password = "123456";
        //输入
        System.out.println("请输入账号：");
        String usernameLogin = sc.next();
        System.out.println("请输入密码：");
        String passwordLogin = sc.next();
        //
        if(username.equalsIgnoreCase(usernameLogin)&&password.equals(passwordLogin)){
            System.out.println("登录成功，欢迎使用！");
        }
        else{
            System.out.println("账号或密码输入错误！");
        }
    }

}
