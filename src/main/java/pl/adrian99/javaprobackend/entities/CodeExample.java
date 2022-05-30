package pl.adrian99.javaprobackend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "code_examples")
@Data
@NoArgsConstructor
public class CodeExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String context;

    @Column
    private Integer exampleOrder;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CodeCategory category;

    @OneToMany(mappedBy = "codeExample")
    private List<Code> codes;
}
