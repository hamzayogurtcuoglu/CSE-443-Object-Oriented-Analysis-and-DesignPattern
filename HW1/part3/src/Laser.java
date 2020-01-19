public class Laser extends ArmoredSuitDecorator {
    /**
     * We will create a component object and we dont need
     * override getCost(),getWeight and getDescription
     * @param suit component object
     */
    public Laser(ArmoredSuit suit) {
        this.suit   = suit;
        cost    = 200;
        weight  = 5.5;
        description = "Laser";
    }
}
