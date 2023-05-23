import java.util.*;

public class Merge {

    // in generale il contratto richiesto é valido

    public static void main(String[] args) {

        List<Integer> l1 = List.of(1, 2, 3, 4);
        List<Integer> l2 = List.of(5, 6, 7, 8);
        List<Integer> l3 = List.of(9, 10);
        List<Integer> l4 = List.of();
        List<Integer> l5 = List.of();

        System.out.println(Merge.<Integer>merge(l1, l2));
        System.out.println(Merge.<Integer>merge(l4, l5));

        System.out.println(Merge.<Integer>merge(l2, l3));

    }

    public static <T> List<T> merge(List<? extends T> l1, List<? extends T> l2){
        if(l1.size() != l2.size()){
            // eccezzione non controllata, esprime parte della pre condizione
            throw new IllegalArgumentException("Lists size doesn't match");
        }
        List<T> merged = new ArrayList<>();
        Iterator<? extends T> iter1 = l1.iterator();
        Iterator<? extends T> iter2 = l2.iterator();
        while(iter1.hasNext()){
            merged.add(iter1.next());
            merged.add(iter2.next());
        }
        return merged;
    }

}
