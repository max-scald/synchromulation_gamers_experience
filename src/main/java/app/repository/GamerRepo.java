package app.repository;

import app.entities.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamerRepo extends JpaRepository<Gamer, Long> {
    Gamer findOneByUuid(String uuid);
}
