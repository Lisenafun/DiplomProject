package ifmo.javaDeveloper.DiplomProject.repository;

import ifmo.javaDeveloper.DiplomProject.entity.Player;
import ifmo.javaDeveloper.DiplomProject.entity.fieldOfGame.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("fieldRepository")
public interface FieldRepository extends JpaRepository<Field, Long> {
    Field findByNameOracle(String nameOracle);
}
