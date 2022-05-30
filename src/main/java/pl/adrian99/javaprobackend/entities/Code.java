package pl.adrian99.javaprobackend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "codes")
@Data
@NoArgsConstructor
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String code;

    @Column
    private Integer codeOrder;

    @ManyToOne
    @JoinColumn(name = "code_example_id")
    private CodeExample codeExample;
}
