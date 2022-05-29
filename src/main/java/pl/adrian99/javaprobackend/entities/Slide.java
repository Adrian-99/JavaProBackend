package pl.adrian99.javaprobackend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "slides")
@Data
@NoArgsConstructor
public class Slide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] slideData;

    @Column
    private Integer slideOrder;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private SlideCategory category;

}
