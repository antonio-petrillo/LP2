import java.util.Arrays;
import java.util.HashMap;

public class Exam {

    public static void main(String[] args) {
        MyString a = new MyString("uno␣due␣tre");
        MyString b = new MyString("uno␣tre␣deu");
        MyString c = new MyString("ert␣unodue");
        MyString d = c.clone();
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(a.hashCode()==b.hashCode());

        a = new MyString("asd;faj i;aljfaslkdjfgh324tas;dlkjl;khrqweasfdj;lkhjt4hqwea;ldkfjsghslejawprnl;xlckaewamlwijfawl;ejf;lskdjfa;lskjfa;lsdkjfa;lskdjfa;slkdjfa;lsdkfja;sldkfja;sldkfja;slkdfja;lsdkjfa;lsdkfja;lsdkjfa;slkdfjghaklerjaelhnlfvjlkanewsdfasfjdalskfjaelkjflskfjowenasoefnsjldcvhni4uawnlkejndlkajncake");
        b = new MyString("as;faj di;aljfaslkdjfgh324tas;dlkjl;khrqweasfdj;lkhjt4hqwea;ldkfjsghslejawprnl;xlckaewamlwijfawl;ejf;lskdjfa;lskjfa;lsdkjfa;lskdjfa;slkdjfa;lsdkfja;sldkfja;sldkfja;slkdfja;lsdkjfa;lsdkfja;lsdkjfa;slkdfjghaklerjaelhnlfvjlkanewsdfasfjdalskfjaelkjflskfjowenasoefnsjldcvhni4uawnlkejndlkajncake");
        System.out.println(a.equals(b));
        System.out.println(a.hashCode()==b.hashCode());
    }

}

class MyString implements Cloneable{
    private String s;
    private char[] sortedChars;
    private HashMap<Character, Integer> map;

    public MyString(String s) {
        this.s = s;
        // for sorted array equals
        sortedChars = s.toCharArray();
        Arrays.sort(sortedChars);

        // for hashmap equals
        map = new HashMap<>();
        for (var c : s.toCharArray()){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 0);
            }
        }
    }

    public MyString clone(){
        return new MyString(s);
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof MyString)){
            return false;
        }
        MyString ms = (MyString) other;

        if (s.length() != ms.s.length()){
            return false;
        }

        // sorted array version
        // for (int i = 0; i < sortedChars.length; i++){
        //     if (sortedChars[i] != ms.sortedChars[i]){
        //         return false;
        //     }
        // }
        //
        // return true;

        // hashmap version
        return map.equals(ms.map);
    }

    public int hashCode(){
       return Arrays.hashCode(sortedChars);
    }

}
