import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProbabilityHandler {
    private static ArrayList<Double> getRatios(ArrayList<Toy> toyList){
        ArrayList<Double> ratios = new ArrayList<>();
        Double probsSum = 0.0;
        for (Toy toy : toyList){
            probsSum += toy.getWeight();
        }
        for (Toy toy : toyList){
            double ratio = toy.getWeight() / probsSum;
            ratios.add(ratio);
        }
        double smallestRatio = Double.MAX_VALUE;
        for (double ratio : ratios){
            if (ratio < smallestRatio){
                smallestRatio = ratio;
            }
        }
        for (int i = 0; i < ratios.size(); i++) {
            double adjustRatio = ratios.get(i) / smallestRatio;
            ratios.set(i, adjustRatio);
        }

        return ratios;
    }

    public static ToyList balanceProbabilities(ArrayList<Toy> toyList){
        Double probsSum = 0.0;
        for (Toy toy : toyList){
            probsSum += toy.getWeight();
        }
        probsSum = 100 - probsSum;
        ArrayList<Double> ratios = getRatios(toyList);
        Double quotient = 0.0;
        for (Double ratio : ratios){
            quotient += ratio;
        }
        probsSum /= quotient;
        for (int i = 0; i < ratios.size(); i++) {
            ratios.set(i, toyList.get(i).getWeight()+ratios.get(i)*probsSum);

            toyList.set(i, new Toy(toyList.get(i).getName(), toyList.get(i).getAmount(), ratios.get(i)));
        }
        return new ToyList(toyList);
    }

    public static Toy getRandomWithChance(ArrayList<Toy> toyList){
        // it took me way too long. to figure out. why the probabilities were weird. turns out it was the balanceProbabilities ~~mis~~use
        toyList = balanceProbabilities(toyList).sortToyList().getToyList();
        //System.out.println(toyList.get(0));
        toyList.sort(new ProbabilityComparator());
        double myRandom = ThreadLocalRandom.current().nextDouble(0, 100);
        Double probsSum = 0.0;
        for (Toy toy : toyList) {
            if (myRandom >= probsSum && myRandom < probsSum+toy.getWeight()){
                //System.out.println(toy);
                return toy;
            }
            probsSum += toy.getWeight();
        }
        return null;
    }
}
