package io.security.springjwt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;

    public static UserEntity createUser(String username, String password, String role) {
        UserEntity userEntity = new UserEntity();
        userEntity.username = username;
        userEntity.password = password;
        userEntity.role = role;
        return userEntity;
    }
}
