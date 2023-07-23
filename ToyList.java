import java.util.ArrayList;
import java.util.Comparator;

public class ToyList {
    private ArrayList<Toy> toyList = new ArrayList<>();

    public ToyList() {
    }

    public ToyList(ArrayList<Toy> toyList) {
        this.toyList = toyList;
    }

    public ArrayList<Toy> getToyList() {
        return toyList;
    }

    public void setToyList(ArrayList<Toy> toyList) {
        this.toyList = ProbabilityHandler.balanceProbabilities(toyList).getToyList();
    }

    public ToyList addToy(Toy toy){
        this.toyList.add(toy);
        return new ToyList(this.toyList);
    }

    public ToyList editToy(Integer i, Toy toy){
        this.toyList.set(i, toy);
        return new ToyList(this.toyList);
    }

    public ToyList deleteToy(int i){
        this.toyList.remove(i);
        return new ToyList(this.toyList);
    }

    public ToyList deleteToy(Toy toy){
        this.toyList.remove(toy);
        return new ToyList(this.toyList);
    }

    public Toy popToy(){
        Toy temp = this.toyList.get(0);
        deleteToy(0);
        return temp;
    }

    public ToyList sortToyList(){
        this.toyList.sort(new ProbabilityComparator());
        return new ToyList(this.toyList);
    }
}
