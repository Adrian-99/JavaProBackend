package pl.adrian99.javaprobackend.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adrian99.javaprobackend.utils.IEntity;
import pl.adrian99.javaprobackend.utils.ParentEntityJsonSerializer;

import javax.persistence.*;

@Entity
@Table(name = "codes")
@Data
@NoArgsConstructor
public class Code implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String code;

    @Column
    private Integer codeOrder;

    @JsonSerialize(using = ParentEntityJsonSerializer.class)
    @ManyToOne
    @JoinColumn(name = "code_example_id")
    private CodeExample codeExample;
}
