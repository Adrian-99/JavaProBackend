package pl.adrian99.javaprobackend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quiz_questions")
@Data
@NoArgsConstructor
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String question;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private QuizCategory category;

    @OneToMany(mappedBy = "question")
    private List<QuizAnswer> answers;
}
