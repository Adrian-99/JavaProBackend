package pl.adrian99.javaprobackend.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import pl.adrian99.javaprobackend.utils.IEntity;
import pl.adrian99.javaprobackend.utils.ImageJsonSerializer;
import pl.adrian99.javaprobackend.utils.ParentEntityJsonSerializer;

import javax.persistence.*;

@Entity
@Table(name = "slides")
@Data
@NoArgsConstructor
public class Slide implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonSerialize(using = ImageJsonSerializer.class)
    @Column
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] slideData;

    @Column
    private Integer slideOrder;

    @JsonSerialize(using = ParentEntityJsonSerializer.class)
    @ManyToOne
    @JoinColumn(name = "category_id")
    private SlideCategory category;

}
