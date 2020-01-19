public class TorSuit extends ArmoredSuit {
    /**
     * We will create a suit object and we dont need
     * override getCost(),getWeight and getDescription
     */
    public TorSuit() {
        cost    = 5000;
        weight  = 50;
        description = "Suit : Tor -> ";
    }
}