/**
 * Proxy provides additional layer of thread safe by
 * interposing specific actions when the object is accessed.
 */
public class ProxyBestDSEEver extends Thread{
    private static BestDSEver object = new BestDSEver();

    /**
     * Synchronized add method. If any methods add,remove and search.
     * All of them work with synchronize.
     *  @param obj what you add object to list.
     */
    public synchronized void add(Object obj) {

        synchronized(object){
            synchronized (object.objList) {
                System.out.println("Inserted -> " + obj);
                object.add(obj);
            }
        }
    }

    /**
     * Synchronized remove method. If any methods add,remove and search.
     * All of them work with synchronize.
     * @param obj what you remove object.
     */
    public synchronized void remove(Object obj) {

        synchronized(object){
            synchronized (object.objList) {
                if (!object.objList.isEmpty()) {
                    System.out.println("Removed -> " + obj);
                    object.remove(obj);
                } else
                    System.out.println("There is no like a obj");
            }
        }
    }

    /**
     * Synchronized search method. If any methods add,remove and search.
     * All of them work with synchronize.
     * @param index
     * @return searching object.
     */
    public synchronized Object get(int index){

        synchronized(object){
            synchronized (object.objList) {
                if (object.objList.size() > index)
                    return object.get(index);
                else
                    System.out.println("There is no like a obj");
                return null;
            }
        }
    }
}
