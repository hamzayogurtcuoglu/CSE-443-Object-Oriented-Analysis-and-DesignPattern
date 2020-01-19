public class FlameThrower extends ArmoredSuitDecorator {
    /**
     * We will create a component object and we dont need
     * override getCost(),getWeight and getDescription
     * @param suit component object
     */
    public FlameThrower(ArmoredSuit suit) {
        this.suit   = suit;
        cost    = 50;
        weight  = 2;
        description = "FlameThrower";
    }
}
