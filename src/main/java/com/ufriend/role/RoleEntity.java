package com.ufriend.role;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class RoleEntity implements Serializable {
    
    @Id
    @Column(name = "id", nullable = false, length = 2)
    @Length(max = 2, min = 2, message = "The id length must be equals to 2, indicating the role code.")
    private String id;

    @Column(name = "name", unique = true, nullable = false, length = 20)
    @Length(min = 1, max = 20)
    @NotNull
    private String name;

    @Column(name = "created_at", columnDefinition = "TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}
