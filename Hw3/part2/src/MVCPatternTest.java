
import javax.swing.SwingUtilities;

public class MVCPatternTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ControllerView view = new ControllerView();
            }
        });
    }
}