package pl.adrian99.javaprobackend.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adrian99.javaprobackend.utils.IEntity;
import pl.adrian99.javaprobackend.utils.ParentEntityJsonSerializer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "code_examples")
@Data
@NoArgsConstructor
public class CodeExample implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String context;

    @Column
    private Integer exampleOrder;

    @JsonSerialize(using = ParentEntityJsonSerializer.class)
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CodeCategory category;

    @OneToMany(mappedBy = "codeExample")
    private List<Code> codes;
}
