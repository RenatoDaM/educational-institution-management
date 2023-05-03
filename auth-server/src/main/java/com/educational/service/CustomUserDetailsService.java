package com.educational.service;

import com.educational.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomUserDetailsService {
    @Autowired
    UserRepository userRepository;


}
