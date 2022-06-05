package pl.adrian99.javaprobackend.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import pl.adrian99.javaprobackend.utils.IEntity;
import pl.adrian99.javaprobackend.utils.ImageJsonSerializer;
import pl.adrian99.javaprobackend.utils.ParentEntityJsonSerializer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quiz_questions")
@Data
@NoArgsConstructor
public class QuizQuestion implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String question;

    @JsonSerialize(using = ImageJsonSerializer.class)
    @Column(nullable = true)
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] image;

    @JsonSerialize(using = ParentEntityJsonSerializer.class)
    @ManyToOne
    @JoinColumn(name = "category_id")
    private QuizCategory category;

    @OneToMany(mappedBy = "question")
    private List<QuizAnswer> answers;
}
