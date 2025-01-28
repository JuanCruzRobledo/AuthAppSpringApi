package org.juanrobledo.authappspring.service;

import org.juanrobledo.authappspring.persistence.entity.UserEntity;
import org.juanrobledo.authappspring.persistence.repository.UserEntityRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    public UserDetailsServiceImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userEntityRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("El usuario no fue encontrado"));

        //Se obtine el rol
        SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_".concat(user.getRole().getName().name()));
        System.out.println("ROL: "+role.getAuthority());
        System.out.println("CONTRASEÑA: "+user.getPassword());
        System.out.println("USUARIO: "+user.getUsername());

        return new User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                List.of(role)
        );

    }
}
