package pl.adrian99.javaprobackend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.adrian99.javaprobackend.utils.IEntity;

import javax.persistence.*;

@Entity
@Table(name = "web_tools")
@Data
@NoArgsConstructor
public class WebTool implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String url;
}
