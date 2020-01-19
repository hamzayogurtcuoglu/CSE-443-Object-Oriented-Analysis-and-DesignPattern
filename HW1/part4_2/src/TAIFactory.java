/**
 * Factory class
 */
public abstract class TAIFactory {
    /**
     * The interface that is implemented with exporting market
     * for customized engines and seats.
     */
    PlaneIngredientFactory ingredientFactory;
    /**
     * abstract method. Subclass create plane model
     * according to choice
     * @param model plane types
     * @return selected plane
     */
    public abstract Plane createPlane(String model) ;

    /**
     * The production of a plane is conducted
     * @param model TPX model type
     * @return selected plane model
     */
    public Plane orderPlane(String model){
        Plane plane;
        plane = createPlane(model);
        System.out.println("\n---- Plane " + plane.getModelName()+ " ----");
        System.out.println("Purpose : " + plane.getPurpose());
        plane.constructSkeleton();
        plane.placeEngines();
        plane.placeSeats();
        return plane;
    }
}
