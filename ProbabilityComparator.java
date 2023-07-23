import java.util.Comparator;
import java.util.Objects;

public class ProbabilityComparator implements Comparator<Toy> {

    @Override
    public int compare(Toy o1, Toy o2) {
        if (Objects.equals(o1.getWeight(), o2.getWeight())){
            return 0;
        } else if (o1.getWeight() > o2.getWeight()){
            return 1;
        } else {
            return -1;
        }
    }
}
