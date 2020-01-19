public abstract class ArmoredSuit {
    /**
     * The  cost of suit and components
     */
    protected double cost;
    /**
     * The weight of suit and components
     */
    protected double weight;
    /**
     * The description of suit and components
     */
    protected String description;

    /**
     * @return the cost value and all classes which use suites of getCost().
     */
    public  double getCost(){
        return cost;
    }

    /**
     * @return the weight value and all classes which use suites of getWeight().
     */
    public double getWeight(){
        return weight;
    }

    /**
     *
     * @return the description and all classes which use suites of getDescription().
     */
    public String getDescription(){
        return description;
    }
}
