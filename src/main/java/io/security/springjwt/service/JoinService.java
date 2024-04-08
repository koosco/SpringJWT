package io.security.springjwt.service;

import io.security.springjwt.dto.JoinDto;
import io.security.springjwt.entity.UserEntity;
import io.security.springjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto) {
        String username = joinDto.getUsername();
        String password = joinDto.getPassword();
        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) {
            return;
        }

        UserEntity data = UserEntity.createUser(username, bCryptPasswordEncoder.encode(password),
            "ROLE_ADMIN");
        userRepository.save(data);
    }
}
