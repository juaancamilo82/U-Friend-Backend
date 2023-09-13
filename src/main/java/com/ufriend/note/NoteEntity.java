package com.ufriend.note;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.ufriend.course.CourseEntity;
import com.ufriend.user.UserEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@Table(name = "notes")
public class NoteEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    @Length(min = 1, max = 100)
    @NotNull
    private String name;

    @Column(name = "percentage", nullable = false)
    @NotNull
    private float percentage;
    
    @Column(name = "value")
    private float value;

    @Column(name = "starts")
    private LocalDateTime starts;

    @Column(name = "ends")
    private LocalDateTime ends;

    @Column(name = "created_at", columnDefinition = "TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @NotNull
    @ManyToOne
    private UserEntity user;

    @NotNull
    @ManyToOne
    private CourseEntity course;

    @ManyToOne
    private NoteEntity father;
}
