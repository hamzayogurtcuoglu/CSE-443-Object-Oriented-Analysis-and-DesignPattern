public class TPX100 extends Plane {

    /**
     * That initializes knowledge of plane
     * @param ingredientFactory specialized factory is ingredient to plane
     */
    public TPX100(PlaneIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        engineInjectionType=ingredientFactory.createEngines();
        seatingCover = ingredientFactory.createSeats();
        model = "TPX 100";
        engine  = "Single jet engine";
        seating = "50";
        skeleton= "Aluminum alloy";
        purpose = "Domestic flights";
    }
}