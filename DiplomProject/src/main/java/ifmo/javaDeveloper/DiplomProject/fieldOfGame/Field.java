package ifmo.javaDeveloper.DiplomProject.fieldOfGame;

import ifmo.javaDeveloper.DiplomProject.entity.Player;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "field_container")
public class Field {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 8, nullable = false)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "id_user")
    private Player player;

    @Column(name = "field")
    private LinkedHashMap<Double, Integer> field;

    @Column(name = "dateOfCreation")
    private LocalDate date;

    private LinkedList<Integer> count;
    private int length;
    private double width;

    public Field(NameOracle nameOracle) {
        count = getCount ();
        this.width = nameOracle.getLengthName ();
        this.length=count.size ()%width==0?(int)(count.size ()/width):(int)(count.size ()/width+1);
    }
    private LinkedList<Integer> getCount() {
        count = new LinkedList<> ();
        for (int i = 1; i <= 9; i++) {
        this.count.add (i);
        }
        for (int i = 10; i < 100; i++) {
            if(i%10 == 0){
                int j = i/10;
                this.count.add (j);
            }else {
                int j = i/10;
                int k = i%10;
                this.count.add (j);
                this.count.add (k);
            }
        }
        this.count.add (1);
        return count;
    }

    public LinkedHashMap<Double, Integer> saveField(){
        this.field = new LinkedHashMap<> (this.length);
        for (double i = 1; i <= this.length; i++) {
            for (double j = 0.1; j <= this.width/10; j+=0.1) {
                if(count.isEmpty ()){
                    break;
                }else{
                    field.put (i+j,count.pollFirst ());
                }
            }
        }
        return field;
    }

    public void getField(){
        saveField ();
        count = getCount ();
        Map<Double, Integer> map = new LinkedHashMap<> (this.length);
        for (double i = 1; i <= this.length; i++) {
            for (double j = 0.1; j <= this.width/10; j+=0.1) {
                if(count.isEmpty ()){
                    break;
                }else {
                    map.put (i + j, count.pollFirst ());
                }
            }
            map.entrySet ().stream ().forEach (item->System.out.print(item.getValue() + " "));
            map.clear ();
            System.out.print ("\n");
        }
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    //    public static void main(String[] args) {
//        NameOracle nameOracle = new NameOracle ();
//        nameOracle.setName ("Stepan");
//        Field field = new Field(nameOracle);
//        field.getField ();
//        System.out.println (field.field);
//    }
}
