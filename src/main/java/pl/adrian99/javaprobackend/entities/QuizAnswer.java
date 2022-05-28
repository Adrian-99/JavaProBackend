package pl.adrian99.javaprobackend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "quiz_answers")
@Data
@NoArgsConstructor
public class QuizAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String answer;

    @Column
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuizQuestion question;
}
