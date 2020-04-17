package app.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Slf4j
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Activity extends AbstractPersistable<Long> {

    @Column(name = "gamer_id")
    private Long gamerId;

    private Date date;

    private Integer value;

    public Activity(Long gamerId, Integer value) {
        this.gamerId = gamerId;
        this.value = value;
        this.date = new Date();
    }
}
