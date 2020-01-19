import java.util.ArrayList;

public class webSite implements Subject {
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
     * the list that keeps subscriber of website
     */
    private ArrayList<Observer> observers;

    /**
     * this constructor creates array for observer list
     */
    public webSite(){
        observers = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public String getPhotograph() {
        return photograph;
    }

    public String getAudio() {
        return audio;
    }

    /**
     * updates of netflix favorite contents
     * @param text favorite films content
     * @param photograph favorite films photo
     * @param audio favorite films audio
     */
    public void updateContent(String text, String photograph, String audio) {
        this.text = text;
        this.photograph = photograph;
        this.audio = audio;
        notifyAllObservers();
    }

    /**
     * If any knowledge is changed then all observer will notified
     */
    @Override
    public void notifyAllObservers() {
        for(Observer subscriber : this.observers)
            subscriber.update();
    }
    /**
     * add in observer list
     * @param subscriber
     */
    @Override
    public void add(Observer subscriber) {
        observers.add(subscriber);
    }
    /**
     * remove in observer list
     * @param subscriber
     */
    @Override
    public void remove(Observer subscriber) {
        observers.remove(subscriber);
    }

}
