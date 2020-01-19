import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static java.lang.Short.MAX_VALUE;
import static javax.swing.GroupLayout.Alignment.CENTER;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 * User Interface Class
 */
public class graphicalUserInterface  extends JFrame{

    private Button submit = new Button();
    private JTextField[][] matrixValue;
    private int row;
    private int column;
    private Button backButton = new Button();
    private linearContext JlinearContext;
    private JComboBox<String> selectedMethod;
    private JPanel Panel;
    private Button submit1;
    private Label equationsNumber;
    private double[][] allMatrix;
    private double[] coefficient;
    private JComboBox<String> equationChoice;
    private JComboBox<String> unknownsChoice;
    private JPanel secondPage;
    private JScrollPane scrollpanel;
    private Label note;
    private Label unknownsNumber;

    public static void main(String args[]) {
        new graphicalUserInterface().setVisible(true);
    }
    /**
     * User Interface Constructor That initialize
     * gui objects and component,selected operations(Layout etc.)
     */
    public graphicalUserInterface() {
        initiliazeObject();
        initializeComponents();
        secondPage.setVisible(true);
        scrollpanel.setVisible(true);
        setSize(900, 600);
        setVisible(true);
        submit();
        getBack();
    }

    /**
     * Fixed layout of graphical user interface
     */
    public void initializeComponents() {

        note.setFont(new Font("Monospaced", 0, 18));
        note.setText("Select following options then, click SUBMIT button - " + " Note: Select square matrix ");

        equationsNumber.setFont(new Font("Monospaced", 0, 14));
        equationsNumber.setText("Select equations :");

        unknownsNumber.setFont(new Font("Monospaced", 0, 14));
        unknownsNumber.setText("Select unknowns :");

        equationChoice.setFont(new Font("Monospaced", 0, 14));
        equationChoice.setMaximumRowCount(10);
        equationChoice.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        unknownsChoice.setFont(new Font("Monospaced", 0, 14));
        unknownsChoice.setMaximumRowCount(10);
        unknownsChoice.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        unknownsChoice.setToolTipText("");

        submit1.setFont(new Font("Monospaced", 1, 18));
        submit1.setLabel("Submit");
        submit1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                otherpage(event);
            }
        });

        GroupLayout PanelLayout = new GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup(CENTER)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelLayout.createParallelGroup(CENTER)
                                        .addGroup(PanelLayout.createSequentialGroup()
                                                .addGroup(PanelLayout.createParallelGroup(CENTER)
                                                        .addComponent(equationsNumber, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                        .addComponent(unknownsNumber, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(PanelLayout.createParallelGroup(CENTER)
                                                        .addComponent(equationChoice, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                        .addComponent(unknownsChoice, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)))
                                        .addComponent(note, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addGroup(PanelLayout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(submit1, PREFERRED_SIZE, 131, PREFERRED_SIZE)))
                                .addContainerGap(296, MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup(CENTER)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(note, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(PanelLayout.createParallelGroup(CENTER)
                                        .addComponent(equationsNumber, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                        .addGroup(PanelLayout.createSequentialGroup()
                                                .addComponent(equationChoice, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                .addGap(10, 10, 100)
                                                .addGroup(PanelLayout.createParallelGroup(CENTER)
                                                        .addComponent(unknownsChoice, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                                        .addComponent(unknownsNumber, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE))))
                                .addGap(65, 65, 65)
                                .addComponent(submit1, PREFERRED_SIZE, 46, PREFERRED_SIZE)
                                .addContainerGap(354, MAX_VALUE))
        );

        equationChoice.getAccessibleContext().setAccessibleName("");
        equationChoice.getAccessibleContext().setAccessibleDescription("");

        secondPage.setPreferredSize(new Dimension(2200, 500));

        GroupLayout secondPageLayout = new GroupLayout(secondPage);
        secondPage.setLayout(secondPageLayout);
        secondPageLayout.setHorizontalGroup(
                secondPageLayout.createParallelGroup(CENTER)
                        .addGap(0, 1000, MAX_VALUE)
        );
        secondPageLayout.setVerticalGroup(
                secondPageLayout.createParallelGroup(CENTER)
                        .addGap(0, 681, MAX_VALUE)
        );

        scrollpanel.setViewportView(secondPage);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Panel, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(scrollpanel, CENTER, DEFAULT_SIZE, 800, MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Panel, PREFERRED_SIZE, DEFAULT_SIZE, PREFERRED_SIZE)
                                .addContainerGap(88, MAX_VALUE))
                        .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(scrollpanel, CENTER))
        );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

    }

    /**
     * All texts,panels,buttons are initialized in this method.
     */
    public void initiliazeObject(){
        Panel = new JPanel();
        note = new Label();

        equationsNumber = new Label();
        equationChoice = new JComboBox<>();

        unknownsNumber = new Label();
        unknownsChoice = new JComboBox<>();

        submit1 = new Button();
        scrollpanel = new JScrollPane();
        secondPage = new JPanel();
    }

    /**
     * This is submit button listener function.
     */
    public void submit() {
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                resultPage(event);
            }
        });
    }

    /**
     * If you select your dimension of matrix and operation.
     * Press submit button then this function will be called.
     * @param event
     */
    private void otherpage(ActionEvent event) {

        String l = (String)equationChoice.getSelectedItem();
        String k = (String)unknownsChoice.getSelectedItem();
        selectedMethod = new JComboBox(new String[] {"Gaussian Elimination","Matrix Inversion"});

        Integer numberOfEquations =Integer.parseInt(l);
        Integer numberOfUnknowns =Integer.parseInt(k);

        row = numberOfEquations;
        column = numberOfUnknowns + 1;

        if (numberOfEquations != numberOfUnknowns) {
            JOptionPane.showMessageDialog(null, "Square matrix!",
                    "Warning", WARNING_MESSAGE);
            return;
        }


        Panel.setVisible(false);
        scrollpanel.setVisible(true);
        matrixValue = new JTextField[row][column];
        secondPage.setVisible(true);
        this.setResizable(true);
        matrixValue = new JTextField[row][column];
        for (int i = 0; i < row; ++i)
            matrixValue[i] = new JTextField[column];
        for (int i = 0; i < row; ++i)
            for (int j = 0; j < column; ++j) {

                JLabel resultOperation = new JLabel();
                matrixValue[i][j] = new JTextField();
                matrixValue[i][j].setSize(new Dimension(50, 25));
                matrixValue[i][j].setVisible(true);
                resultOperation.setVisible(true);
                resultOperation.setSize(50, 25);
                if (j == column - 2) {
                    resultOperation.setText("x" + (j+1) + " =");
                }
                else if (j != column - 1)
                    resultOperation.setText("x" + (j+1) + " +");
                matrixValue[i][j].setLocation((j)*50 + (j+1)*5 + j*50+50, (i)*25 + (i+1)*5+20);
                resultOperation.setLocation((j+1)*50 + (j + 1)*5 + j*50+50, (i)*25 + (i+1)*5+20);
                secondPage.add(matrixValue[i][j]);
                secondPage.add(resultOperation);
            }
        submit.setVisible(true);
        submit.setSize(120,40);
        backButton.setSize(90,40);
        backButton.setVisible(true);
        selectedMethod.setSize(510, 35);

        selectedMethod.setVisible(true);
        submit.setLabel("SOLVE EQUATION");
        backButton.setLabel("GO BACK");
        backButton.setLocation(5 + 375 ,30*(row+1)+ 180);
        submit.setLocation(5 + 475,30*(row+1)+180);
        selectedMethod.setLocation(250,30*(row+1)-6+100);
        secondPage.add(submit);
        secondPage.add(backButton);
        secondPage.add(selectedMethod);
        allMatrix = new double[row][column-1];
        coefficient = new double[row];


    }

    /**
     * Finally, that is solution of the operation function
     * for GUI
     * @param event
     */
    public void resultPage(ActionEvent event) {

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (matrixValue[i][j].getText() == null || matrixValue[i][j].getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter all coefficients",
                            "Warning", WARNING_MESSAGE);
                    return;

                }
            }
        }
        try {
            for (int i = 0; i < row; ++i) {
                coefficient[i] = Double.parseDouble(matrixValue[i][column-1].getText());
                for (int j = 0; j < column-1; ++j) {
                    allMatrix[i][j] = Double.parseDouble(matrixValue[i][j].getText());
                }
            }
            if (selectedMethod.getSelectedItem().equals("Gaussian Elimination"))
                JlinearContext = new linearContext(new operationGaussianElimination());
            else
                JlinearContext = new linearContext(new operationMatrixInversion());

            submit.setEnabled(false);
            double operationResult[] = JlinearContext.doOperation(allMatrix, coefficient);
            submit.setEnabled(true);
            secondPage.removeAll();
            secondPage.setVisible(false);

            for (int i = 0; i < row; ++i) {
                JLabel resultOperation = new JLabel();
                resultOperation.setText(("X" + (i+1) + "  =  " + operationResult[i]));
                resultOperation.setVisible(true);
                resultOperation.setSize(250, 30);
                resultOperation.setLocation(100, (i+2)*resultOperation.getHeight());
                secondPage.add(resultOperation);
            }

            scrollpanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            secondPage.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected ERROR",
                    "Error", ERROR_MESSAGE);
            submit.setEnabled(true);
        }
    }

    /**
     * If you want to change your operation or
     * selected dimension or unknown variable.
     * This function listens to get back the page.
     */
    public void getBack(){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                secondPage.removeAll();
                scrollpanel.setVisible(false);
                secondPage.setVisible(false);
                Panel.setVisible(true);

                for (int i = 0; i < row; ++i) {
                    for (int j = 0; j < column; ++j) {
                        matrixValue[i][j].setText("");
                    }
                }
            }
        });
    }

}
