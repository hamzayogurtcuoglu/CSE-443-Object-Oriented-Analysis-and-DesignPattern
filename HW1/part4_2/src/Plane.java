/**
 * The abstract class that is extended model of planes (TPX100,TPX200,TPX300)
 * and the keeps knowledge of plane.
 */
public abstract class Plane {
    /**
     * model of plane
     */
     String model;
    /**
     * type of engine
     */
     String engine;
    /**
     * type of skeleton
     */
     String skeleton;
    /**
     * type of seat of plane
     */
     String seating;
    /**
     * That keeps why this plane is produced.
     */
     String purpose;
    /**
     * Engine Injection Type
     */
     Engine engineInjectionType;
    /**
     * Seating Cover Object
     */
     Seat seatingCover;
    /**
     * The object that keeps ingredient factory
     */
     PlaneIngredientFactory ingredientFactory;

    /**
     * Print skeleton type
     */
    public void constructSkeleton(){
        System.out.println("Skeleton : " + getSkeleton());
    }

    /**
     * Engines of plane
     */
    public void placeEngines(){
        System.out.println("Engine : " + getEngine()+" and "+engineInjectionType.getEngines());
    }

    /**
     * type and number of seat
     */
    public void placeSeats(){
        System.out.println("Seats : " + getSeatNum()+" "+seatingCover.getSeats());
    }

    /**
     * plane mode getter
     * @return plane model
     */
    public String getModelName() {
        return model;
    }

    /**
     * getter engine
     * @return engine
     */
    public String getEngine() {
        return engine;
    }

    /**
     * getter skeleton of plane
     * @return skeleton
     */
    public String getSkeleton() {
        return skeleton;
    }

    /**
     * number of seats
     * @return number of seats
     */
    public String getSeatNum() {
        return seating;
    }

    /**
     * why this plane is produced
     * @return reason of plane
     */
    public String getPurpose() {
        return purpose;
    }
}