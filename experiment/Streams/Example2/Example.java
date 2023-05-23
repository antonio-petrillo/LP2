import java.util.*;
import java.util.stream.*;

public class Example {

    public static void main(String[] args) {

        Stream<String> s = Stream.of("ciao", "mondo", "", " ", "as;lkdfjasdl;kfja;sld",
                "oiausfoea", "aseralsdfn", "weralfdl", "asldjrfoweajfasfkfaklsdjflakej",
                "asafjlsdkfjlezl;lke", "ciao", "alerjawejlfkl;asejf", "asl;kfjl;weakjafl;kefjl;aekjaf");

        long count = s.filter(str -> str.length() > 10).count();
        System.out.println(count);

        s = Stream.of("ciao", "mondo", "", " ", "as;lkdfjasdl;kfja;sld",
                "oiausfoea", "aseralsdfn", "weralfdl", "asldjrfoweajfasfkfaklsdjflakej",
                "asafjlsdkfjlezl;lke", "ciao", "alerjawejlfkl;asejf", "asl;kfjl;weakjafl;kefjl;aekjaf");

        Set<String> l = s.collect(Collectors.toSet());
        System.out.println(l);

    }

    public static Stream<String> get() {
        return Stream.of("ciao", "mondo", "", " ", "as;lkdfjasdl;kfja;sld",
                "oiausfoea", "aseralsdfn", "weralfdl", "asldjrfoweajfasfkfaklsdjflakej",
                "asafjlsdkfjlezl;lke", "ciao", "alerjawejlfkl;asejf", "asl;kfjl;weakjafl;kefjl;aekjaf");
    }

}
