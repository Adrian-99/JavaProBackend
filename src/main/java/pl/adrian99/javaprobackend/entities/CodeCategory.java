package pl.adrian99.javaprobackend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "code_categories")
@Data
@NoArgsConstructor
public class CodeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    private List<CodeExample> codeExamples;
}
