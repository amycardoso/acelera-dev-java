package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotNull
    @Size(max = 100)
    String fullName;

    @NotNull
    @Email
    @Size(max = 100)
    String email;

    @NotNull
    @Size(max = 50)
    String nickname;

    @NotNull
    @Size(max = 255)
    String password;

    @NotNull
    @CreatedDate
    LocalDate createdAt;

    @OneToMany
    private List<Submission> submissionList;

    @OneToMany
    private List<Candidate> candidateList;

}