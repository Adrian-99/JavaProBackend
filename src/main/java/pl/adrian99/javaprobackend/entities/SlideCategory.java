package pl.adrian99.javaprobackend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adrian99.javaprobackend.utils.IEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "slide_categories")
@Data
@NoArgsConstructor
public class SlideCategory implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Slide> slides;

}
