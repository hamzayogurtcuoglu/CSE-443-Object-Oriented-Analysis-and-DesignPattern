public class OtherFactory extends TAIFactory {
    /**
     * A market OtherFactory is customizing plane.
     */
    public OtherFactory() {
        ingredientFactory = new OtherIngredientFactory();
    }

    /**
     *  What you want plane that returned after
     *  the plane is prepared.
     * @param model plane model
     * @return  prepared model
     */
    public Plane createPlane(String model) {
        if (model.equals("TPX100"))
            return new TPX100(ingredientFactory);
        else if (model.equals("TPX200"))
            return new TPX200(ingredientFactory);
        else if (model.equals("TPX300"))
            return new TPX300(ingredientFactory);
        else return null;
    }
}
