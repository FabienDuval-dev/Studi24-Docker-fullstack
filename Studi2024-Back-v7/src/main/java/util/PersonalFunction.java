package util;

import entity.Key;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PersonalFunction {

    public static String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public static boolean checkPassword(String plainPassword, Key key) {
        String hashIsItTheSame = hashPassword(plainPassword);
        return hashIsItTheSame.matches(key.getHashValue());
    }

}
