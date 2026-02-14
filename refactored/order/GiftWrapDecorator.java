package refactored.order;

public class GiftWrapDecorator extends OrderDecorator {

    public GiftWrapDecorator(Order order) {
        super(order);
    }

    @Override
    public int getCost() {
        return decoratedOrder.getCost() + 50;
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription() + " + Gift Wrap";
    }
}
