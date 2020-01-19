public class EurasiaFactory extends TAIFactory {

    /**
     * A market EurasiaFactory is customizing plane.
     */
    public EurasiaFactory() {
        ingredientFactory = new EurasiaIngredientFactory();
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
