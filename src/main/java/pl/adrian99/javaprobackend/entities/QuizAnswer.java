package pl.adrian99.javaprobackend.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adrian99.javaprobackend.utils.IEntity;
import pl.adrian99.javaprobackend.utils.ParentEntityJsonSerializer;

import javax.persistence.*;

@Entity
@Table(name = "quiz_answers")
@Data
@NoArgsConstructor
public class QuizAnswer implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String answer;

    @Column
    private boolean isCorrect;

    @JsonSerialize(using = ParentEntityJsonSerializer.class)
    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuizQuestion question;
}
