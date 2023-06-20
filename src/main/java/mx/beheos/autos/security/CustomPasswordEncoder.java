package mx.beheos.autos.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {
    private final PasswordEncoder delegate;

    public CustomPasswordEncoder() {
        this.delegate = new BCryptPasswordEncoder();
    }

    @Override
    public String encode(CharSequence rawPassword) {
        String cadenaAdicional = "Jh0n l3N0n_";
        String passwordWithPrefix = cadenaAdicional + rawPassword.toString();
        return delegate.encode(passwordWithPrefix);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String cadenaAdicional = "Jh0n l3N0n_";
        String passwordWithPrefix = cadenaAdicional + rawPassword.toString();
        return delegate.matches(passwordWithPrefix, encodedPassword);
    }
}