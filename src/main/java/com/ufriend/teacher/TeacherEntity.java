package com.ufriend.teacher;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@Table(name = "teachers")
public class TeacherEntity implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    @Length(min = 1, max = 100)
    @NotNull
    private String name;

    @Column(name = "lastname", length = 100)
    @Size(min = 1, max = 100)
    @NotNull
    private String lastname;

    @Column(name = "email", unique = true, nullable = false, length = 150)
    @Length(min = 1, max = 150)
    @NotNull
    @Email
    private String email;

    @Column(name = "phone", length = 50)
    @Size(min = 1, max = 50)
    private String phone;

    @Column(name = "created_at", columnDefinition = "TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}
