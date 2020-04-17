package app.repository;

import app.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country,Integer> {

    Country findOneByCode(String code);

    Country findOneById(Integer id);
}
