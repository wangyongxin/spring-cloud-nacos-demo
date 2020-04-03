import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    public static void main(String[] args) {
        //生成nacos密码 直接覆盖数据库
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        //insert into users(username, password, enabled) values ('test','$2a$10$S44FT9z7GtJmYK.BC65mouN6VAaOqFDc9g0uMDH6F/EcUalP9HB1K',1);
        //insert roles (username, role) values ('test', 'ROLE_ADMIN');
    }
}
