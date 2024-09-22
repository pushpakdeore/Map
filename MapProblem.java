package pushpak34map;
import java.util.*;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.TreeMap;
import java.util.PriorityQueue;
public class MapProblem {
    public static void frequancyCount(String input){
        //1 frequancy count
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : input.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> el : freq.entrySet()){
            System.out.println("key :"+el.getKey()+ "  value :"+ el.getValue());
        }
    }
    // 4. First Non-Repeated Character using LinkedHashMap
    public static void firstnonRepetedCahracter(String input){
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(char c :input.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character, Integer> e :map.entrySet()){
            if(e.getValue()==1){
                System.out.println("fist non Repeared character :"+e.getKey());
                return;
            }
        }
        System.out.println("No non repeted charater");
    }
    public static void sortByValue(HashMap<String, Integer> map){
        List<Map.Entry<String ,Integer>> sort = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        System.out.println("sorted by value: "+sort);
    }
//    6. Duplicate Elements in Array: Given an array of integers, find the duplicates and their
//    counts using a HashMap.

    public static void duplicateInArray(int [] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : arr){
            map.put(i, map.getOrDefault(i,0)+1);

        }
        for(Map.Entry<Integer ,Integer> l :map.entrySet()){
            if(l.getValue() >1){
                System.out.println("Key is :"+l.getKey() +"  Count of duplicate Element is : "+ l.getValue());
            }
        }

    }
//    7. Phone Book: Implement a phone book using a TreeMap where you can add, remove,
//    and search for contacts by name
    public static void phoneBook() {
        TreeMap<String, String> phone = new TreeMap<>();
        phone.put("Pushpak", "8080685915");
        phone.put("Kunal", "9080685915");
        phone.put("Snehal", "7080685915");
        //add
        phone.put("Aksha", "6080685915");

        //remove
        phone.remove("Kunal");

        //serch
        System.out.println(phone.get("Snehal"));

        System.out.println(phone);
    }
//    8. Employee Records: Create a program to store employee records (name, ID,
//    department) and allow searching by ID using a HashMap.

    public static void emplyeeRecord(){
        class Employee{
            String name ;
            String department;
            Employee(String name,String department){
                this.name = name;
                this.department =department;
            }
            public String toString(){
                return name+ "( "+department+" )";
            }
        }
        HashMap<Integer,Employee> emp = new HashMap<>();
        emp.put(1,new Employee("Pushpak","HR"));
        emp.put(5,new Employee("Kuanl","HR"));
        emp.put(3,new Employee("Snehal","HR"));
        System.out.println(emp);
    }
//    9. Top K Frequent Elements: Given an array of integers, return the k most frequent
//    elements using a HashMap.
    public static void topFrequant(int [] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num :arr){
            map.put(num, map.getOrDefault(num,0)+1);

        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq =new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        pq.addAll(map.entrySet());

        List<Integer> result =new ArrayList<>();
        for (int i =0;i<k;i++){
            result.add(pq.poll().getKey());
        }
        System.out.println(result);
    }
    //10. Intersection of Two Arrays: Find the intersection of two arrays using a HashMap.
    public static List<Integer> findIntersection(int [] num1,int[] num2){
        Map<Integer,Integer> map =new HashMap<>();
        for(int num : num1){
            map.put(num, map.getOrDefault(num,0)+1);

        }
        List<Integer> intersection = new ArrayList<>();

        for(int num :num2){
            if (map.containsKey(num) && map.get(num)>0){
                intersection.add(num);
                map.put(num,map.get(num)-1);
            }
        }
        return  intersection;
    }



 
    public static void main(String[] args) {
        //1
        frequancyCount("pushpakdeoere");

        //4
        firstnonRepetedCahracter("pushpak");

        //5
        HashMap<String , Integer> m = new HashMap<>();
        m.put("Pushpak",1);
        m.put("Kuanl",34);
        m.put("Snehal",3);
        sortByValue(m);

//        6
        int[] arr = {1,2,3,4,5,1,2};
        duplicateInArray(arr);

        //7
        phoneBook();

        //8
        emplyeeRecord();

        //9top k frequent element
        int [] num  = {1,2,3,4,5,6};
        int k =2;
        topFrequant(num,k);

//        10
        int [] num1 ={1,2,2,1};
        int [] num2= {2,2};
        List<Integer> result =findIntersection(num1,num2);
        System.out.println("Intersention array"+result);







    }

}
