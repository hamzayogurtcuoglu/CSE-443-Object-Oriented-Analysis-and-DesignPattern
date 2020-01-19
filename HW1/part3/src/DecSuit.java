public class DecSuit extends ArmoredSuit {
    /**
     * We will create a sut object and we dont need
     * override getCost(),getWeight and getDescription.
     */
    public DecSuit() {
        cost    = 500;
        weight  = 25;
        description = "Suit : Dec -> ";
    }
}
