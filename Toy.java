public class Toy {
    private static Integer id = -1;
    private String name;
    private Integer amount;
    private Double weight;

    public Toy() {
        id++;
    }

    public Toy(String name, Integer amount, Double weight) {
        this.name = name;
        this.amount = amount;
        this.weight = weight;
        id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", weight=" + weight +
                '}';
    }
}
