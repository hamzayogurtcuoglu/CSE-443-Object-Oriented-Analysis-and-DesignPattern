/**
 * The interface that is implemented with exporting market
 * for customized engines and seats.
 */
public interface PlaneIngredientFactory {
    /**
     * Customized engine
     * @return customized engine
     */
    public Engine createEngines();

    /**
     * Customized Seats
     * @return customized seats.
     */
    public Seat createSeats();
}