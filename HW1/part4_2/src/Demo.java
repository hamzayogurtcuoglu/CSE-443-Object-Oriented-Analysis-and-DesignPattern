
/**
 * Main method for creating factory
 * and order plane.
 */
public class Demo {
    /**
     * A client can order what the model (TPX100,TPX200,TPX300)
     * according to factory.
     * @param args
     */
    public static void main(String[] args) {
        TAIFactory store = new DomesticFactory();
        Plane plane = store.orderPlane("TPX100");
        plane = store.orderPlane("TPX200");
        plane = store.orderPlane("TPX300");

        store = new EurasiaFactory();
        plane = store.orderPlane("TPX100");
        plane = store.orderPlane("TPX200");
        plane = store.orderPlane("TPX300");

        store = new OtherFactory();
        plane = store.orderPlane("TPX100");
        plane = store.orderPlane("TPX200");
        plane = store.orderPlane("TPX300");
    }
}