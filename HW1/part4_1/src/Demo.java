/**
 * Main method for creating TAIFactory and ModelPlane
 */
public class Demo {
    /**
     * A client can order what the model (TPX100,TPX200,TPX300)
     * @param args
     */
    public static void main(String[] args) {
        TAIFactory tpx = new TPXModel();
        Plane plane = tpx.orderPlane("TPX100");
        plane = tpx.orderPlane("TPX200");
        plane = tpx.orderPlane("TPX300");
    }
}
