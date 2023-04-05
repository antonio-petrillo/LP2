import java.util.Set;
import java.util.HashSet;

public class Container {

    private Set<Container> connected;
    private Integer[] amount;

    public Container(){
        connected = new HashSet<>();
        amount = new Integer[1];
        amount[0] = Integer.valueOf(0);
        connected.add(this);
    }

    public static void main(String[] args) {
        Container a = new Container();
        Container b = new Container();
        Container c = new Container();
        Container d = new Container();

        a.addWater(12);
        d.addWater(8);

        a.connect(b);

        System.out.println(a + " " + b + " " + c + " " + d);

        b.connect(c);

        System.out.println(a + " " + b + " " + c + " " + d);

        c.connect(d);

        System.out.println(a + " " + b + " " + c + " " + d);
    }

    public Integer getAmount(){
        return connected.isEmpty() ? amount[0] : amount[0] / connected.size();
    }

    public void addWater(Integer amount){
        this.amount[0] += amount;
    }

    public void connect(Container c){
        amount[0] += c.amount[0];
        for(var other : c.connected){
            connected.add(other);
        }
        c.connected = connected;
        c.amount = amount;
    }

    @Override
    public String toString(){
        return getAmount().toString();
    }

}
