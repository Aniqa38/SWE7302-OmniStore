package refactored.order;

public class BasicOrder implements Order {

    private int baseCost;

    public BasicOrder(int baseCost) {
        this.baseCost = baseCost;
    }

    @Override
    public int getCost() {
        return baseCost;
    }

    @Override
    public String getDescription() {
        return "Basic Order";
    }
}

