import java.io.IOException;
import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface{

    private final HashMap<String, LinkedList<CourseDBElement>> hashtable;
    private final int buckets;

    public CourseDBStructure(int n){
        int size = get_4k_plus_3_prime(n);
        hashtable = new LinkedHashMap<>(size);
        buckets = size;
    }

    public CourseDBStructure(String test, int n){
        hashtable = new HashMap<>(n);
        buckets = n;
    }


    @Override
    public void add(CourseDBElement element) {
        String crn = Integer.toString(element.getCRN());
        String hash = Integer.toString(crn.hashCode());


        // Check to see if a bucket exists in the hashtable
        // If it exists then add the element to the linkedlist and place the bucket back in the hashtable
        // Otherwise make a new linked list and place in in the hashtable
        LinkedList<CourseDBElement> val;
        if (!hashtable.containsKey(hash)){
            val = new LinkedList<>();
            val.add(element);
        }
        else{
            val = hashtable.get(hash);
            val.add(element);
        }
        hashtable.put(hash, val);

    }

    @Override
    public CourseDBElement get(int crn) throws IOException {
        String hash = Integer.toString(Integer.toString(crn).hashCode());

        if (hashtable.containsKey(hash)){
            LinkedList<CourseDBElement> val = hashtable.get(hash);
            return val.getLast();
        }
        else {
            throw new IOException();
        }

    }

    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> courses = new ArrayList<>();
        Set<String> keys = hashtable.keySet();

        for (String key : keys) {
            LinkedList<CourseDBElement> val = hashtable.get(key);
            String courseString = val.getLast().toString();
            courses.add("\n"+courseString);
        }

        for (int i=0, j=courses.size() - 1; i < j; i++ ){
            courses.add(i, courses.remove(j));
        }

        return courses;
    }

    @Override
    public int getTableSize() {
        return buckets;
    }



    private int get_4k_plus_3_prime(int num){
        double loading_factor = 1.5;
        int base = (int) Math.round(num / loading_factor);

        while (!is_4k_plus_3_prime(base)){
            base += 1;
        }

        return base;
    }

    private boolean is_4k_plus_3_prime(int num){
        int x = num - 3;
        return (x % 4 == 0) && (is_prime(num));
    }

    private boolean is_prime(int num) {
        // Not prime if even
        if (num % 2 == 0) return false;

        // Code breaking check
        if (num <= 1) return false;

        // Check from 2 to n-1
        for (int i = 2; i < num; i++){
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
