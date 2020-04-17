package app.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Data
@Entity
@ToString(exclude = {"activities","country"})
@EqualsAndHashCode(exclude = "activities",callSuper = true)
@Table(name = "gamers")
public class Gamer extends AbstractPersistable<Long> {

    @Column(name = "uuid")
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Country country;

    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "money")
    private Integer money;

    @OneToMany()
    @JoinColumn(name = "gamer_id")
    private List<Activity> activities = new ArrayList<>();
}
