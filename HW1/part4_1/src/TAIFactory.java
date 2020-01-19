/**
 * Factory class
 */

public abstract class TAIFactory {
    /**
     * The production of a plane is conducted
     * @param typeOfModel TPX model type
     * @return selected plane model
     */
    public Plane orderPlane(String typeOfModel) {
        Plane plane = createPlane(typeOfModel);
        System.out.println("\n---- Plane " + plane.getModel()+ " ----");
        plane.purpose();
        plane.constructSkeleton();
        plane.placeEngines();
        plane.placeSeats();
        return plane;
    }

    /**
     * abstract method. Subclass create plane model
     * according to choice
     * @param typeOfModel plane types
     * @return selected plane
     */
    abstract Plane createPlane(String typeOfModel);
}