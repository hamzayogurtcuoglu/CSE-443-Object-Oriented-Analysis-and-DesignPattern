public class TPX300 extends Plane {

    /**
     * That initializes knowledge of plane
     * @param ingredientFactory specialized factory is ingredient to plane
     */
    public TPX300(PlaneIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        engineInjectionType=ingredientFactory.createEngines();
        seatingCover = ingredientFactory.createSeats();
        model = "TPX 300";
        engine  = "Quadro jet engines";
        seating = "250";
        skeleton= "Titanium alloy";
        purpose = "Transatlantic flights";
    }
}