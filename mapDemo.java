package pushpak34map;
import java.util.*;

public class mapDemo {
    public static void main(String[] args) {
        Map<String , Integer> studets =new HashMap<>();
        studets.put("Pushpak" ,1);
        studets.put("Kunal" ,1);
        studets.put("Akash" ,1);
        studets.put("Surya" ,4);

        System.out.println(studets.get("Akash"));
        System.out.println(studets.get("Pushpak"));
        studets.put("Pushpak",23);
        //1

        System.out.println(studets.keySet());
        for(String name :studets.keySet()){
            System.out.println(name+ " " + studets.get(name));
        }

        //2
        Set<String> keys = studets.keySet();
        for(String key : keys){
            System.out.println("Key : "+key);
        }

        //3
//        Print all key value
        Set<Map.Entry<String ,Integer>> entries = studets.entrySet();
        for(Map.Entry<String,Integer> entry  : entries){
            System.out.println("Key : "+entry.getKey()+" value ; "+entry.getValue());
        }

        //4
        System.out.println(studets);

        //int hascode
        System.out.println(studets.hashCode());








    }


}
