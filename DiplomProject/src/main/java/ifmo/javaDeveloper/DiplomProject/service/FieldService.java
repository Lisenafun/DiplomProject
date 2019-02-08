//package ifmo.javaDeveloper.DiplomProject.service;
//
//import ifmo.javaDeveloper.DiplomProject.entity.fieldOfGame.Field;
//import ifmo.javaDeveloper.DiplomProject.entity.fieldOfGame.NameOracle;
//
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//
//public class FieldService {
//
//    private Field field;
//    private LinkedList<Integer> count;
//    private int length;
//    private double width;
//
//    public FieldService(NameOracle nameOracle) {
//        count = getCount ();
//        this.width = nameOracle.getLengthName ();
//        this.length=count.size ()%width==0?(int)(count.size ()/width):(int)(count.size ()/width+1);
//    }
//    private LinkedList<Integer> getCount() {
//        count = new LinkedList<> ();
//        for (int i = 1; i <= 9; i++) {
//            this.count.add (i);
//        }
//        for (int i = 10; i < 100; i++) {
//            if(i%10 == 0){
//                int j = i/10;
//                this.count.add (j);
//            }else {
//                int j = i/10;
//                int k = i%10;
//                this.count.add (j);
//                this.count.add (k);
//            }
//        }
//        this.count.add (1);
//        return count;
//    }
//
//    public LinkedHashMap<Double, Integer> saveField(){
//
//        this.field = new LinkedHashMap<> (this.length);
//        for (double i = 1; i <= this.length; i++) {
//            for (double j = 0.1; j <= this.width/10; j+=0.1) {
//                if(count.isEmpty ()){
//                    break;
//                }else{
//                    field.put (i+j,count.pollFirst ());
//                }
//            }
//        }
//        return field;
//    }
//}
