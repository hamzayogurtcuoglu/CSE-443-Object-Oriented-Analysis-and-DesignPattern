public class AutoRifle extends ArmoredSuitDecorator {
    /**
     * We will create a component object and we dont need
     * override getCost(),getWeight and getDescription
     * @param suit component object
     */
    public AutoRifle(ArmoredSuit suit) {
        this.suit = suit;
        cost    = 30;
        weight  = 1.5;
        description = "AutoRifle";
    }
}
