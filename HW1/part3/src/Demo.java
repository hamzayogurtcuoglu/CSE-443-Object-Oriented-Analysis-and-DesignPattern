
public class Demo {
    public static void main(String[] args) {
        ArmoredSuit suit = null;
        suit = new DecSuit();
        suit = new FlameThrower(suit);
        suit = new AutoRifle(suit);
        suit = new AutoRifle(suit);
        suit = new RocketLauncher(suit);
        System.out.println();
        System.out.println("Cost and Weight :" +  suit.getDescription() + "  =  "
                + suit.getCost() + "k TL ,  " + suit.getWeight() + "kg\n");


        suit = null;
        suit = new OraSuit();
        suit = new RocketLauncher(suit);
        suit = new Laser(suit);
        suit = new RocketLauncher(suit);
        System.out.println("Cost and Weight :" +  suit.getDescription() + "  =  "
                + suit.getCost() + "k TL ,  " + suit.getWeight() + "kg");
        suit = null;


        suit = new TorSuit();
        suit = new AutoRifle(suit);
        suit = new AutoRifle(suit);
        suit = new RocketLauncher(suit);
        System.out.println();
        System.out.println("Cost and Weight :" +  suit.getDescription() + "  =  "
                + suit.getCost() + "k TL ,  " + suit.getWeight() + "kg");
        suit = null;


    }

}

