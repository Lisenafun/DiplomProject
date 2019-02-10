package ifmo.javaDeveloper.DiplomProject.entity.fieldOfGame;

import ifmo.javaDeveloper.DiplomProject.entity.Player;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "field_container")
public class Field {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 8, nullable = false)
    private int id;

    @Column(name = "nameOracle")
    private String nameOracle;

    @ManyToOne()
    @JoinColumn(name = "player_id")
    private Player player;

    @Column(name = "field")
    private LinkedHashMap<Double, Integer> field;


    private static LinkedList<Integer> numbers;
    private int length;
    private double width;

    public Field() {
    }

    public Field(String nameOracle) {
        numbers = getNumbers ();
        this.width = nameOracle.length ();
        this.length= numbers.size ()%width==0?(int)(numbers.size ()/width):(int)(numbers.size ()/width+1);
    }
    private LinkedList<Integer> getNumbers() {
        numbers = new LinkedList<> ();
        for (int i = 1; i <= 9; i++) {
        numbers.add (i);
        }
        for (int i = 10; i < 100; i++) {
            if(i%10 == 0){
                int j = i/10;
                numbers.add (j);
            }else {
                int j = i/10;
                int k = i%10;
                numbers.add (j);
                numbers.add (k);
            }
        }
        numbers.add (1);
        return numbers;
    }

    public LinkedHashMap<Double, Integer> saveFieldMap(){
        this.field = new LinkedHashMap<> (this.length);
        for (double i = 1; i <= this.length; i++) {
            for (double j = 0.1; j <= this.width/10; j+=0.1) {
                if(numbers.isEmpty ()){
                    break;
                }else{
                    field.put (i+j, numbers.pollFirst ());
                }
            }
        }
        return field;
    }
//
//    public void getField(){
//        saveFieldMap ();
//        numbers = getNumbers ();
//        Map<Double, Integer> map = new LinkedHashMap<> (this.length);
//        for (double i = 1; i <= this.length; i++) {
//            for (double j = 0.1; j <= this.width/10; j+=0.1) {
//                if(numbers.isEmpty ()){
//                    break;
//                }else {
//                    map.put (i + j, numbers.pollFirst ());
//                }
//            }
//            map.entrySet ().stream ().forEach (item->System.out.print(item.getValue() + " "));
//            map.clear ();
//            System.out.print ("\n");
//        }
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setField(LinkedHashMap<Double, Integer> field) {
        this.field = field;
    }

    public LinkedHashMap<Double, Integer> getField() {
        return field;
    }

    public String getNameOracle() {
        return nameOracle;
    }

    public void setNameOracle(String nameOracle) {
        this.nameOracle = nameOracle;
    }

    //    public static void main(String[] args) {
//        NameOracle nameOracle = new NameOracle ();
//        nameOracle.setName ("Stepan");
//        Field field = new Field(nameOracle);
//        field.getField ();
//        System.out.println (field.field);
//    }
}
