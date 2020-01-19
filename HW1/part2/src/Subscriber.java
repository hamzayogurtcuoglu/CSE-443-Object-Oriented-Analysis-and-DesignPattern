/**
 * That subscriber class that keeps name,photograph,audio about last notification
 */
public class Subscriber implements Observer {

    /**
     * Name of Subscriber
     */
    private String name;
    /**
     * Text of content
     */
    private String text;
    /**
     * Photograph of content
     */
    private String photograph;
    /**
     * Audio of content
     */
    private String audio;
    /**
     * Subscriber registers a web that gives a notification
     * when content is changed.
     */
    private webSite web;

    /**
     * Constructor of subscriber is added to website
     * Subscriber keeps reference of website
     * @param webSite website reference
     * @param name name of subscriber
     */
    public Subscriber(webSite webSite, String name) {
        this.web = webSite;
        this.name = name;
        web.add(this);
    }

    /**
     * update if subscriber get a notify
     */
    @Override
    public void update() {
        text = web.getText();
        photograph = web.getPhotograph();
        audio = web.getAudio();
        display();
    }

    /**
     * display content of subscriber of last favorite thing
     */
    @Override
    public void display() {
        System.out.println("----------------------------------------");
        System.out.println("Notify : " + name + " , check your update.");
        System.out.println("Text : " + text);
        System.out.println("Audio : " + audio);
        System.out.println("Photograph : " + photograph);
        System.out.println("----------------------------------------");
    }
}
