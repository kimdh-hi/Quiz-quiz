package com.dhk.onlinequiz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private ProblemType pType;

    @Column(nullable = true)
    private int obj_count;

    @Column(nullable = true)
    private String p1;
    @Column(nullable = true)
    private String p2;
    @Column(nullable = true)
    private String p3;
    @Column(nullable = true)
    private String p4;
    @Column(nullable = true)
    private String p5;

    private String answer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_template_id")
    private QuizTemplate quizTemplate;
}
