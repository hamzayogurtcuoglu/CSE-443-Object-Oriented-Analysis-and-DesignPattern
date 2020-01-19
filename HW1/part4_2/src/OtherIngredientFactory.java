public class OtherIngredientFactory implements PlaneIngredientFactory{
    /**
     * Customized engine
     * @return customized GearedTurbofanEngine
     */
    @Override
    public Engine createEngines() {
        return new GearedTurbofanEngine();
    }
    /**
     * Customized Seats
     * @return customized LeatherSeat.
     */
    @Override
    public Seat createSeats() {
        return new LeatherSeat();
    }

}