package app.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Slf4j
@Data
@Entity
@Table(name = "countries")
@EqualsAndHashCode(exclude = "gamers",callSuper = true)
@ToString(exclude = "gamers")
public class Country extends AbstractPersistable<Integer> {

    private String code;

    @OneToMany()
    @JoinColumn(name = "country_id")
    private List<Gamer> gamers;

    public Country(){}

    public Country(String code){
        this.code = code;
    }
}
