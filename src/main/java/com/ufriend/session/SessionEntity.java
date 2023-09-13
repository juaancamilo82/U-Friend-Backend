package com.ufriend.session;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.ufriend.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sessions")
public class SessionEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "token", nullable = false)
    @Length(min = 1, max = 255)
    @NotNull
    private String token;

    @Column(name = "refresh_token", nullable = false)
    @Length(min = 1, max = 255)
    @NotNull
    private String refreshToken;

    @Column(name = "is_logged_in", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    @NotNull
    private Boolean isLoggedIn = true;

    @NotNull
    @ManyToOne
    private UserEntity user;

    @Column(name = "created_at", columnDefinition = "TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
