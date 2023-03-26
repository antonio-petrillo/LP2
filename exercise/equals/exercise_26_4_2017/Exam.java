public class Exam {

    public static void main(String[] args) {

    }

}

class Room  {

    // unknown details
    private Date booking;
    private Person booker;

    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
        if (getClass() != o.getClass()){
            return false;
        }

        Room r = (Room) o;

        // criteria a, is not valid
        // if a room have no booking then cannot be compared to itself

        // criteria b, is valid
        return booking == null && r.booking == null;

        // criteria c, is valid
        return booking == null && r.booking == null ||
            booker.equals(r.booker);

        // criteria d, is not valid
        // if a date booking is null,
        // then an item is not equal to itself.

    }


}
