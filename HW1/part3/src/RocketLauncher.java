public class RocketLauncher extends ArmoredSuitDecorator{
    /**
     * We will create a component object and we dont need
     * override getCost(),getWeight and getDescription
     * @param suit component object
     */
    public RocketLauncher(ArmoredSuit suit) {
        this.suit   = suit;
        cost    = 150;
        weight  = 7.5;
        description = "RocketLauncher";
    }
}
