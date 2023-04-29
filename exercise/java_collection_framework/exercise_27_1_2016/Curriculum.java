import java.util.*;

public class Curriculum implements Iterable<Curriculum.Job> {

    private String author;
    private Job head, tail;

    public Curriculum(String author) {
        this.author = author;
    }

    public Job addJob(String description, int year) {
        Job job = new Job(description, year);
        if (tail == null) {
            head = job;
            tail = job;
        } else {
            tail.next = job;
            tail = job;
        }
        return job;
    }

    @Override
    public Iterator<Job> iterator() {
        return new Iterator<Job>() {
            Job iter = head;

            @Override
            public boolean hasNext() {
                return iter != null;
            }

            @Override
            public Job next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Job cur = iter;
                iter = iter.next;
                return cur;
            }
        };
    }

    public static class Job {
        private String description;
        private int year;
        private Job next;

        private Job(String description, int year) {
            this.description = description;
            this.year = year;
            next = null;
        }

        public Job next() {
            return next;
        }

        @Override
        public String toString() {
            return description + " : " + year;
        }
    }

    public static void main(String[] args) {
        Curriculum cv = new Curriculum("Walter White");
        Curriculum.Job j1 = cv.addJob("Chimico", 1995);
        Curriculum.Job j2 = cv.addJob("Insegnante", 2005);
        Curriculum.Job j3 = cv.addJob("Cuoco", 2009);
        System.out.println(j2.next());
        System.out.println(j3.next());
        for (Job j : cv) {
            System.out.println(j);
        }
    }

}
