package com.educational.service;

import com.educational.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

    public JPAUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final var user = userRepository.findByEmail(email);

        final var simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + user.get().getType().name());
        return new User(
                user.get().getEmail(),
                user.get().getPassword(),
                List.of(simpleGrantedAuthority)
        );
    }

}