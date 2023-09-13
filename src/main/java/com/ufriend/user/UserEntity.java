package com.ufriend.user;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.ufriend.language.LanguageEntity;
import com.ufriend.role.RoleEntity;
import com.ufriend.theme.ThemeEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Data
@Table(name = "users")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 100)
    @Length(min = 1, max = 100)
    private String name;

    @Column(name = "lastname", length = 100)
    @Length(min = 1, max = 100)
    private String lastname;

    @Column(name = "photo")
    private String photo;

    @Column(name = "email", nullable = false, length = 150)
    @Length(min = 1, max = 150)
    @NotNull
    @Email
    private String email;

    @Column(name = "password", nullable = false)
    @Length(min = 6, max = 255)
    @NotNull
    private String password;

    @Column(name = "phone", length = 50)
    @Length(min = 1, max = 150)
    private String phone;

    @Column(name = "confirmed", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean confirmed;

    @Column(name = "created_at", columnDefinition = "TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @NotNull
    @ManyToOne
    private RoleEntity role;

    @NotNull
    @ManyToOne
    private LanguageEntity language;

    @NotNull
    @ManyToOne
    private ThemeEntity theme;

    private String encodePassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public void setPassword(String password) {
        this.password = encodePassword(password);
    }
}
