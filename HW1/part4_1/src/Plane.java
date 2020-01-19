/**
 * Plane class keeps information according to the model of the plane
 */
public abstract class Plane {
    /**
     * model of plane
     */
    String model = null;
    /**
     * it keeps which purpose of is used
     */
    String purpose = null;
    /**
     * type skeleton of plane
     */
    String skeleton = null;
    /**
     * type engine of plane
     */
    String engine = null;
    /**
     * it keeps number of seating of plane
     */
    String seating = null;

    /**
     * return model type
     * @return model type
     */
    public String getModel(){
        return model;
    }

    /**
     * printing purpose of plane
     */
    void purpose(){
        System.out.println("Purpose = " + purpose);
    }

    /**
     * printing construct of skeleton
     */
    void constructSkeleton(){
        System.out.println("Skeleton = " + skeleton);
    }

    /**
     * printing construct of engine
     */
    void placeEngines(){
        System.out.println("Engine = " + engine);
    }

    /**
     * printing construct of Seats
     */
    void placeSeats(){
        System.out.println("Seating = " + seating);
    }



}