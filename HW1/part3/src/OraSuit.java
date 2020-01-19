public class OraSuit extends ArmoredSuit {
    /**
     * We will create a suit object and we dont need
     * override getCost(),getWeight and getDescription
     */
    public OraSuit() {
        cost    = 1500;
        weight  = 30;
        description = "Suit : Ora -> ";
    }
}