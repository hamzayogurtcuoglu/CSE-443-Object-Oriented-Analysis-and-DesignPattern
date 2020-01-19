public class TPX200 extends Plane {

    /**
     * That initializes knowledge of plane
     * @param ingredientFactory specialized factory is ingredient to plane
     */
    public TPX200(PlaneIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        engineInjectionType=ingredientFactory.createEngines();
        seatingCover = ingredientFactory.createSeats();
        model = "TPX 200";
        engine  = "Twin jet engines";
        seating = "100";
        skeleton= "Nickel alloy";
        purpose = "Domestic and short international flights";
    }
}