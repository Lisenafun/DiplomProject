package ifmo.javaDeveloper.DiplomProject.service;

import ifmo.javaDeveloper.DiplomProject.entity.Player;
import ifmo.javaDeveloper.DiplomProject.entity.fieldOfGame.Field;
import ifmo.javaDeveloper.DiplomProject.repository.FieldRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("fieldService")
public class FieldService {

//    private Field field;
    private FieldRepository fieldRepository;

    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public Field findFieldByNameOracle(String nameOracle) {
        return fieldRepository.findByNameOracle (nameOracle);
    }
    public void saveField(Player player, String nameOracle){
        Field field = new Field (nameOracle);
        field.saveFieldMap ();
        field = fieldRepository.findByNameOracle (nameOracle);
        player.setFields ((new HashSet<Field> (Arrays.asList(field))));
        fieldRepository.save (field);
    }
}
