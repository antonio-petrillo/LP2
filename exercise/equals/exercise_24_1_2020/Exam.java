public class Exam {



}

class Cart{

    @Override
    public boolean equals(Object other){
        // criteria a is not valid
        // if a cart is empty it is not equal to itself

        // criteria b is valid

        // criteria c is not valid
        // the relation is not transitive
        // A(x1, x2), B(x1, x3), C(x3, x4) => A == B and B == C, but A != C

        // criteria d is not valid
        // the relation is not transitive
        // A(x...).cost() == 1, B(y...).cost() == 9, C(z...).cost() == 18
        // A == B, B == C, A != C
    }


}

class Product {
    private int price;

    public Product(int price){
        this.price = price;
    }

}
