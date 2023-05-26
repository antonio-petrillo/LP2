import java.util.HashSet;

public class MyString implements Cloneable{

    private String s;
    private HashSet<Character> hs = new HashSet<>();

    public MyString(String s){
        this.s = s;
        for (int i = 0; i < s.length(); i++){
            hs.add(s.charAt(i));
        }
    }

    @Override
    public boolean equals(Object other){
        if(other == null){
            return false;
        }
        if (getClass() != other.getClass()){
            return false;
        }
        MyString ms = (MyString) other;
        return hs.equals(ms.hs);
    }

    @Override
    public int hashCode(){
        int hash = 0;
        for (var c : hs){
            hash += c.hashCode();
        }
        return hash;
    }

    @Override
    public MyString clone(){
        var s = new String(this.s);
        return new MyString(s);
    }

    public static void main(String[] args) {
        MyString a = new MyString("freddo");
        MyString b = new MyString("defro");
        MyString c = new MyString("caldo");
        MyString d = a.clone();

        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(d.equals(a));
    }

}
