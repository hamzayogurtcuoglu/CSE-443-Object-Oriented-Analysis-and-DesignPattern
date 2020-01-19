public class DomesticIngredientFactory implements PlaneIngredientFactory {

    /**
     * Customized engine
     * @return customized turbojetEngine
     */
    @Override
    public Engine createEngines() {
        return new TurbojetEngine();
    }

    /**
     * Customized Seats
     * @return customized VelvetSeat.
     */
    @Override
    public Seat createSeats() {
        return new VelvetSeat();
    }


}