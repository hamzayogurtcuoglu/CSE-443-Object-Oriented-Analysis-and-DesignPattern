/**
 * The Decorator class is derived by component of suit .
 */
public abstract class ArmoredSuitDecorator extends ArmoredSuit{
    protected ArmoredSuit suit;

    /**
     *
     * @return It returns the product name and additional component
     */
    @Override
    public String getDescription(){
        return suit.getDescription() + " + " + description;
    }

    /**
     *
     * @return It returns the total cost
     */
    @Override
    public double getCost(){
        return suit.getCost() + cost;
    }

    /**
     *
     * @return It returns the total weight
     */
    @Override
    public double getWeight() {
        return suit.getWeight() + weight;
    }
}
