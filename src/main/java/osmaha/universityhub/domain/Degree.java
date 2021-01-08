package osmaha.universityhub.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "degree")
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private EDegree title;

    public Degree() {
    }

    public Degree(Integer id, EDegree title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EDegree getTitle() {
        return title;
    }

    public void setTitle(EDegree title) {
        this.title = title;
    }
}
