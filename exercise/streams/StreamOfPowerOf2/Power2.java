import java.util.stream.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import java.util.function.*;

public class Power2 {

    public static void main(String[] args) {
        System.out.println("power of 2 from 0 to 11");
        powersOf2().limit(12).forEach(System.out::println);
        System.out.println(binaryRepresentation(42).toList());
        System.out.println(binaryRepresentationV2(42).toList());
        System.out.println(binarySumRepresentation(42));
        System.out.println(binarySumRepresentationV2(42));
        System.out.println("\ncas");
        System.out.println(binarySumRepresentationV3(42));
    }

    public static Stream<Integer> powersOf2() {
        return Stream.iterate(Integer.valueOf(1), (i) -> i << 1);
    }

    // public static List<Integer> binaryRepresentation(Integer n) {
    // return Stream.iterate(n, (i) -> i != 0, (i) -> i >> 1)
    // .map((i) -> (i % 2 == 0) ? 1 : 0)
    // .toList();
    // }

    public static Stream<Integer> binaryRepresentation(Integer n) {
        return Stream.iterate(n, (i) -> i != 0, (i) -> i >> 1)
                .map((i) -> (i % 2 == 0) ? 1 : 0);
    }

    public static Stream<Integer> binaryRepresentationV2(Integer n) {
        LinkedList<Integer> stack = new LinkedList<>();
        Stream.iterate(n, (i) -> i != 0, (i) -> i >> 1)
                .map((i) -> (i % 2 == 0) ? 1 : 0)
                .forEachOrdered(stack::push);
        return stack.stream();
    }

    public static List<Integer> binarySumRepresentation(Integer n) {
        Stream<Integer> representation = binaryRepresentation(n);
        Function<Integer, Integer> f = new Function<>() {
            AtomicInteger power = new AtomicInteger(1 << representation.count() - 1);

            @Override
            public Integer apply(Integer i) {
                int p = power.get();
                power.set(p >> 1);
                return i * p;
            }

        };
        return binaryRepresentation(n).map(f).toList();
    }

    public static List<Integer> binarySumRepresentationV2(Integer n) {
        Function<Integer, Integer> f = new Function<>() {
            AtomicInteger power = new AtomicInteger(1);

            @Override
            public Integer apply(Integer i) {
                int p = power.get();
                power.set(p << 1);
                return i * p;
            }
        };
        return binaryRepresentationV2(n).map(f).toList();
    }

    public static List<Integer> binarySumRepresentationV3(Integer n) {
        Function<Integer, Integer> f = new Function<>() {
            int[] p = { 0 };

            @Override
            public Integer apply(Integer i) {
                int power = mul(p, 2);
                return i * power;
            }
        };
        return binaryRepresentationV2(n).map(f).toList();
    }

    private static boolean cas(int[] p, int oldVal, int newVal) {
        if (p[0] != oldVal)
            return false;
        p[0] = newVal;
        return true;
    }

    private static int mul(int[] p, int factor) {
        boolean done = false;
        while (!done) {
            int value = p[0];
            if (value == 0) {
                done = cas(p, value, 1);
            } else {
                done = cas(p, value, value * factor);
            }
        }
        return p[0];
    }

}
