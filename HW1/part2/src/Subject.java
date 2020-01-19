/**
 * The interface of netflix that means website.
 */
public interface Subject {
    /**
     * add in observer list
     * @param observer
     */
    void add(Observer observer);

    /**
     * remove in observer list
     * @param observer
     */
    void remove(Observer observer);

    /**
     * If any knowledge is changed then all observer will notified
     */
    void notifyAllObservers();
}
