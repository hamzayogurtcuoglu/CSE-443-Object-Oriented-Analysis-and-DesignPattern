public class EurasiaIngredientFactory implements PlaneIngredientFactory {

    /**
     * Customized engine
     * @return customized turbofanEngine
     */
    @Override
    public Engine createEngines() {
        return new TurbofanEngine();
    }

    /**
     * Customized Seats
     * @return customized LinenSeat.
     */
    @Override
    public Seat createSeats() {
        return new LinenSeat();
    }


}