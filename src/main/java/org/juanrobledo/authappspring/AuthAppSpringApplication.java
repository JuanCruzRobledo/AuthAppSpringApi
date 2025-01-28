package org.juanrobledo.authappspring;

import org.juanrobledo.authappspring.persistence.entity.RoleEntity;
import org.juanrobledo.authappspring.persistence.entity.RoleEnum;
import org.juanrobledo.authappspring.persistence.entity.UserEntity;
import org.juanrobledo.authappspring.persistence.repository.RoleEntityRepository;
import org.juanrobledo.authappspring.persistence.repository.UserEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthAppSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthAppSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner init(PasswordEncoder passwordEncoder, UserEntityRepository userRepository, RoleEntityRepository roleRepository){
        return args -> {
            // Crear roles
            RoleEntity adminRole = RoleEntity.builder().name(RoleEnum.ADMIN).build();
            RoleEntity userRole = RoleEntity.builder().name(RoleEnum.USER).build();
            RoleEntity guestRole = RoleEntity.builder().name(RoleEnum.GUEST).build();

            // Guardar roles en la base de datos
            roleRepository.save(adminRole);
            roleRepository.save(userRole);
            roleRepository.save(guestRole);

            // Crear usuarios con el rol ADMIN
            UserEntity admin1 = UserEntity.builder()
                    .username("admin1")
                    .password(passwordEncoder.encode("password123"))
                    .email("admin1@example.com")
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .isEnabled(true)
                    .role(adminRole)
                    .build();

            UserEntity admin2 = UserEntity.builder()
                    .username("admin2")
                    .password(passwordEncoder.encode("password123"))
                    .email("admin2@example.com")
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .isEnabled(true)
                    .role(adminRole)
                    .build();

            // Crear usuarios con el rol USER
            UserEntity user1 = UserEntity.builder()
                    .username("user1")
                    .password(passwordEncoder.encode("password123"))
                    .email("user1@example.com")
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .isEnabled(true)
                    .role(userRole)
                    .build();

            UserEntity user2 = UserEntity.builder()
                    .username("user2")
                    .password(passwordEncoder.encode("password123"))
                    .email("user2@example.com")
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .isEnabled(true)
                    .role(userRole)
                    .build();

            // Crear usuarios con el rol GUEST
            UserEntity guest1 = UserEntity.builder()
                    .username("guest1")
                    .password(passwordEncoder.encode("password123"))
                    .email("guest1@example.com")
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .isEnabled(true)
                    .role(guestRole)
                    .build();

            UserEntity guest2 = UserEntity.builder()
                    .username("guest2")
                    .password(passwordEncoder.encode("password123"))
                    .email("guest2@example.com")
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .isEnabled(true)
                    .role(guestRole)
                    .build();

            // Guardar usuarios en la base de datos
            userRepository.save(admin1);
            userRepository.save(admin2);
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(guest1);
            userRepository.save(guest2);
        };
    }
}
