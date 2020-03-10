import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    public static void main(String[] args) {
        //生成nacos密码 直接覆盖数据库
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}
