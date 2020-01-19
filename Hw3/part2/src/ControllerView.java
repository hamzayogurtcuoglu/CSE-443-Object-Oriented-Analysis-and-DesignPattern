import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;


public class ControllerView {
    private JFrame frame;
    private JPanel gui;
    private JButton mutexButton;
    private JButton cancel;
    private JButton restart;
    private JButton start;
    private  JMenuBar mb;
    private JMenu m2;
    private JLabel label,label2,label3;
    private JTextField tf,tf0,tf2,tf3,tf4,
                       tf5,tf6;
    JMenuItem m11;
    JMenuItem m22;
    static int processNO = -1;
    static int threadNumber = 0;
    static int matrixSize = 0;
    static int isMutexesAndMonitors = 0;
    static ComplexNumber[][] A;
    static ComplexNumber[][] B;

    public ControllerView() {
        customizeFrame();
        createMainPanel();
        createMenu();
        createStartButton();
        createRestartButton();
        createCancelButton();
        createSyncButton();
        createText();
        addComponentsToFrame();
        frame.setVisible(true);
    }

    /**
     * create text and label for gui
     */
    private void createText() {
        label = new JLabel("Number of Threads-_-");
        tf0 = new JTextField(20); // accepts upto 20 characters
        tf = new JTextField(14); // accepts upto 14 characters
        label2 = new JLabel("-_-Size of the Matrices");
        label3 = new JLabel("            -Elapsed Time-          ");
        tf2 = new JTextField(14); // accepts upto 14 characters
        tf3 = new JTextField(35); // accepts upto 35 characters
        tf4 = new JTextField(35); // accepts upto 35 characters
        tf5 = new JTextField(35); // accepts upto 35 characters
        tf6 = new JTextField(35); // accepts upto 35 characters
    }

    /**
     * Create Help Menu
     */
    private void createMenu() {
        mb = new JMenuBar();
        m2 = new JMenu("Help");
        mb.add(m2);
        m11 = new JMenuItem("Enter Thread -> 2 , 4 or 8");
        m22 = new JMenuItem("Enter Matrix Size Coefficient of 32");
        m2.add(m11);
        m2.add(m22);
    }

    /**
     * Frame Customization
     */
    private void customizeFrame() {
        frame = new JFrame();
        frame = new JFrame("Threads Incorporated");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 400);
    }

    /**
     * Create Main Panel
     */
    private void createMainPanel() {
        gui = new JPanel();
    }


    /**
     * There are Action Codes that works when press restart button
     */
    private void createRestartButton()  {
        restart = new JButton("Restart");
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create the worker
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

                    @Override
                    protected Void doInBackground() throws InterruptedException {
                        return runProcess(++processNO);
                    }
                };
                start.setEnabled(false);
                worker.execute();
                start.setEnabled(true);
            }
        });
    }

    /**
     * Cancel to process when press to cancel button
     */

    private void createCancelButton()  {
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create the worker
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

                    @Override
                    protected Void doInBackground() throws InterruptedException {
                        tf5.setText("Called Process");
                        tf6.setText("Called Process");
                        ++processNO;
                        return null;
                    }
                };
                cancel.setEnabled(false);
                worker.execute();
                cancel.setEnabled(true);
            }
        });
    }

    /**
     * There are Action Codes that works when press Start button
     */
    private void createStartButton()  {
        start = new JButton("Start");

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create the worker
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

                    @Override
                    protected Void doInBackground() throws InterruptedException {
                        return runProcess(++processNO);
                    }
                };
                start.setEnabled(false);
                worker.execute();
                start.setEnabled(true);
            }
        });
    }

    /**
     * When the button is pressed. I will select which implementation
     * that is synchronization(mutex(es) and monitor(s)) or just notify ...
     */
    private void createSyncButton()  {
        mutexButton = new JButton("You want synchronization(mutex(es) and monitor(s))?");
        mutexButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // Create the worker
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

                    @Override
                    protected Void doInBackground() throws InterruptedException {
                        if(isMutexesAndMonitors == 0){
                            tf0.setText("Mutex(es) and Monitor(s)");
                            isMutexesAndMonitors = 1;
                        }else{
                            tf0.setText("Synchronized, Wait, Notify");
                            isMutexesAndMonitors = 0;
                        }
                        return null;
                    }
                };
                mutexButton.setEnabled(false);
                worker.execute();
                mutexButton.setEnabled(true);
            }
        });
    }

    /**
     * All component are added to gui
     */
    private void addComponentsToFrame() {
        mb.add(m2);
        m2.add(m11);
        m2.add(m22);
        gui.add(tf0);
        gui.add(mutexButton);
        gui.add(label); // Components Added using Flow Layout
        gui.add(label); // Components Added using Flow Layout
        gui.add(label2);
        gui.add(tf);
        gui.add(tf2);
        gui.add(cancel);
        gui.add(restart);
        gui.add(start);
        gui.add(label3);
        gui.add(tf3);
        gui.add(tf4);
        gui.add(tf5);
        gui.add(tf6);
        tf0.setText("Synchronized, Wait, Notify");
        frame.getContentPane().add(BorderLayout.CENTER, gui);
        frame.getContentPane().add(BorderLayout.NORTH, mb);

    }

    /**
     * Produce 2D matrix with complex numbers
     * @param A 2D Matrix
     * @param B 2D Matrix
     */
    static void produceComplexMatrix(ComplexNumber [][] A,ComplexNumber [][] B){
        int n = A.length;
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                A[i][j] = new ComplexNumber(i,j);
                B[i][j] = new ComplexNumber(j,i);
            }
        }
    }

    /**
     * All operation is done in this method
     * @param processNO Process No -> Not Thread No
     * @return
     */
    Void runProcess(int processNO){
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText("");
        threadNumber = Integer.parseInt(tf.getText());
        matrixSize = Integer.parseInt(tf2.getText());

        if ((threadNumber==2||threadNumber==4||threadNumber==8)
                &&(matrixSize%32==0)){
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

                @Override
                protected Void doInBackground() throws Exception {
                    tf3.setText("A and B both of size "+
                            matrixSize +"x"+matrixSize  +" filled with complex numbers.");
                    return null;
                }
            };
            worker.execute();

            A = new ComplexNumber[matrixSize][matrixSize];
            B = new ComplexNumber[matrixSize][matrixSize];
            produceComplexMatrix(A, B);
            tf4.setText(threadNumber + " threads work ... You will see finish time." );
            long startTime = System.nanoTime();
            if (isMutexesAndMonitors==0){
                SynchronizedWaitNotify.result = null;
                DFT.result = null;
                SynchronizedWaitNotify object=null;
                SynchronizedWaitNotify.result = new ComplexNumber[matrixSize][matrixSize];
                DFT.result= new ComplexNumber[matrixSize][matrixSize];
                for (int i=0; i<threadNumber; i++)
                {
                    object = new SynchronizedWaitNotify();
                    object.start(i,processNO);
                }
                try {
                    object.join();


                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }else{
                MonitorLock object=null;
                MonitorLock.result = null;
                DFT.result = null;
                MonitorLock.result = new ComplexNumber[matrixSize][matrixSize];
                DFT.result= new ComplexNumber[matrixSize][matrixSize];
                MonitorLock.threadNumber = 0;
                for (int i=0; i<threadNumber; i++)
                {
                    object = new MonitorLock();
                    object.start(i,processNO);
                }
                try {
                    object.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }



            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;


            SwingWorker<Void, Void> worker2 = new SwingWorker<Void, Void>() {

                @Override
                protected Void doInBackground() {
                    tf5.setText(threadNumber + " threads finished -> " + totalTime/1000000000.0 + "s" );
                    if (threadNumber == 8)
                        tf6.setText("1 thread would finish -> " + totalTime*1.3*1.3*1.3/1000000000 + "s");
                    else if (threadNumber == 4)
                        tf6.setText("1 thread would finish -> " + totalTime*1.3*1.3/1000000000 + "s");
                    else
                        tf6.setText("1 thread would finish -> " + totalTime*1.3/1000000000 + "s");

                    return null;
                }
            };
            worker2.execute();
        }else{
            String message = "\"Enter Thread -> 2 , 4 or 8\"\n"
                    + "Enter Matrix Size Coefficient of 32 \n";

            JOptionPane.showMessageDialog(new JFrame(), message, "Warning",
                    JOptionPane.ERROR_MESSAGE);
        }
        printDFT();
        return null;
    }

    /**
     * Print screen of DTF result
     */
    void printDFT(){
        for (int i = 0 ; i<matrixSize;i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.print("(" + DFT.result[i][j].real + "," + DFT.result[i][j].img +")");
            }
            System.out.println();
        }
    }

}
