package org.juanrobledo.authappspring.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Anotaciones a nivel base de datos
    @Column(unique = true, nullable = false)
    //Anotaciones a nivel clase
    @NotNull
    private String username;

    @Column(nullable = false)
    @NotNull
    private String password;

    @Email
    @NotNull
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @ManyToOne //Relacion many to one debido a que a nivel base de datos muchos usuarios van a tener un mismo rol
    @JoinColumn(
            //NO tiene el UNIQUE = true debido a que varios usuarios van a referenciar a un rol repetidamente
            nullable = false,
            name = "role_id"
    )
    private RoleEntity role;

    //Configuraciones de usuarios
    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "is_account_non_expired")
    private boolean isAccountNonExpired;

    @Column(name = "is_account_non_locked")
    private boolean isAccountNonLocked;

    @Column(name = "is_credentials_non_expired")
    private boolean isCredentialsNonExpired;

}
