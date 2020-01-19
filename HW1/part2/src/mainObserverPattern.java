/**
 * The ObserverPattern for creating subject and observers
 */
public class mainObserverPattern {

    public static void main(String[] args) {

        webSite webSite = new webSite();

        Subscriber trump= new Subscriber(webSite, "trump");
        Subscriber hamza = new Subscriber(webSite, "hamza");
        Subscriber putin= new Subscriber(webSite, "putin");
        Subscriber rte = new Subscriber(webSite, "rte");

        String text = "new episode Lacasa de Papel";
        String photograph = "photographs of bank sketches";
        String audio = "Bella ciao";

        webSite.updateContent(text, photograph, audio);

        webSite.remove(hamza);

        text = "new episode The Walking Dead";
        photograph = "photographs of zombies";
        audio = "Sound of Rick";

        webSite.updateContent(text, photograph, audio);


    }
}
