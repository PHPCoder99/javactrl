import java.util.ArrayList;

public class ToyRoulette { // im not 100% confident thats how roulette is spelled.
    private ToyList toyList = new ToyList();
    private ToyList prizesList = new ToyList(); // shuffle toyList with probabilities included, basically.

    public ToyRoulette() {
    }

    public ToyRoulette(ToyList toyList) {
        this.toyList = toyList;
    }

    public ToyList getToyList() {
        return toyList;
    }

    public void setToyList(ToyList toyList) {
        this.toyList = toyList;
    }

    public ToyList getPrizesList() {
        return prizesList;
    }

    public void setPrizesList(ToyList prizesList) {
        this.prizesList = prizesList;
    }

    public ToyList startGame(){
        ArrayList<Toy> toyArrayList = new ArrayList<>(this.toyList.getToyList());
        ToyList newToyList = new ToyList(toyArrayList);
        while (!newToyList.getToyList().isEmpty()){
            Toy toy = ProbabilityHandler.getRandomWithChance(newToyList.getToyList());
            prizesList.addToy(toy);
            newToyList.getToyList().remove(toy);
        }
        return prizesList;
    }
}
