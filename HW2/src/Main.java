import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Graphical User Interface and Initialization population
 */
public class Main extends JPanel{

    static GenericAlgorithm MaximizeVersion1,MaximizeVersion2,MaximizeVersion3;
    public static void main(String[] args) {

        int width = 370, height = 350;

        int n = 3; // Number of threads

        JFrame frame = new JFrame("Generic Algorithm GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(1200, 500);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Help");
        mb.add(m1);
        JMenuItem m11 = new JMenuItem("Start -> New Population");
        JMenuItem m22 = new JMenuItem("Run -> Resume");
        JMenuItem m23 = new JMenuItem("Pause -> Stopping generic algoritm for now.");
        JMenuItem m24 = new JMenuItem("Stop -> Cut off the running program.");

        m1.add(m11);
        m1.add(m22);
        m1.add(m23);
        m1.add(m24);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JButton run = new JButton("Run");
        JButton stop = new JButton("Stop");
        JButton pause = new JButton("Pause");
        JButton start = new JButton("Start");
        panel.add(run);
        panel.add(stop);
        panel.add(pause);
        panel.add(start);

        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        start.addActionListener(new ActionListener() {
            JInternalFrame inner1 , inner2, inner3;
            @Override
            public void actionPerformed(ActionEvent evt) {

                // Create our own Thread to do the counting
                    frame.getContentPane().removeAll();
                    frame.repaint();
                    frame.getContentPane().add(BorderLayout.SOUTH, panel);
                    JDesktopPane desktop = new JDesktopPane();
                    desktop.setBounds(0,0,400,900);

                    for (int i=0; i<n; i++)
                    {
                        if (i == 0) {
                            MaximizeVersion1 = new Version1();
                            MaximizeVersion1.population.initializePopulation(100);
                            MaximizeVersion1.population.calculateFitness();
                            MaximizeVersion1.VersionName = "Version-1";

                            inner1 = new JInternalFrame("Roulette wheel selection - Crossover1 ");
                            inner1.setBounds(10, 30, width, height);
                            MaximizeVersion1.plot = new Plot(MaximizeVersion1.population.individuals.length,MaximizeVersion1.population.individuals);
                            inner1.add(MaximizeVersion1.plot);
                            inner1.setVisible(true);
                            MaximizeVersion1.start();
                        }else if (i == 1){
                            MaximizeVersion2 = new Version2();
                            MaximizeVersion2.population.initializePopulation(100);
                            MaximizeVersion2.population.calculateFitness();
                            MaximizeVersion2.VersionName = "Version-2";


                            inner2 = new JInternalFrame("Rank selection - Crossover2");
                            inner2.setBounds(410,30 , width, height);
                            MaximizeVersion2.plot = new Plot(MaximizeVersion2.population.individuals.length,MaximizeVersion2.population.individuals);
                            inner2.add(MaximizeVersion2.plot);
                            inner2.setVisible(true);

                            MaximizeVersion2.start();
                        }else{

                            MaximizeVersion3 = new Version3();
                            MaximizeVersion3.population.initializePopulation(100);
                            MaximizeVersion3.population.calculateFitness();
                            MaximizeVersion3.VersionName = "Version-3";


                            inner3 = new JInternalFrame("Tournament selection - Crossover 1");
                            inner3.setBounds(810, 30, width, height);
                            MaximizeVersion3.plot = new Plot(MaximizeVersion3.population.individuals.length,MaximizeVersion3.population.individuals);
                            inner3.add(MaximizeVersion3.plot);
                            inner3.setVisible(true);

                            MaximizeVersion3.start();
                        }
                    }
                    desktop.add(inner1);
                    desktop.add(inner2);
                    desktop.add(inner3);
                    frame.add(desktop);
                    frame.getContentPane().add(BorderLayout.SOUTH, panel);
                    frame.getContentPane().add(BorderLayout.NORTH, mb);
                    frame.setVisible(true);

                    frame.getContentPane().removeAll();
                    frame.repaint();
                    frame.getContentPane().add(BorderLayout.SOUTH, panel);
                    desktop = new JDesktopPane();
                    desktop.setBounds(0, 0, 400, 900);

                    inner1 = new JInternalFrame("Roulette wheel selection - Crossover1 ");
                    inner1.setBounds(10, 30, width, height);
                    MaximizeVersion1.plot = new Plot(MaximizeVersion1.population.individuals.length, MaximizeVersion1.population.individuals);
                    inner1.add(MaximizeVersion1.plot);
                    inner1.setVisible(true);

                    inner2 = new JInternalFrame("Rank selection - Crossover2");
                    inner2.setBounds(410, 30, width, height);
                    MaximizeVersion2.plot = new Plot(MaximizeVersion2.population.individuals.length, MaximizeVersion2.population.individuals);
                    inner2.add(MaximizeVersion2.plot);
                    inner2.setVisible(true);

                    inner3 = new JInternalFrame("Tournament selection - Crossover 1");
                    inner3.setBounds(810, 30, width, height);
                    MaximizeVersion3.plot = new Plot(MaximizeVersion3.population.individuals.length, MaximizeVersion3.population.individuals);
                    inner3.add(MaximizeVersion3.plot);
                    inner3.setVisible(true);

                    desktop.add(inner1);
                    desktop.add(inner2);
                    desktop.add(inner3);
                    frame.add(desktop);
                    frame.getContentPane().add(BorderLayout.SOUTH, panel);
                    frame.getContentPane().add(BorderLayout.NORTH, mb);
                    frame.setVisible(true);

                    update( frame,panel,desktop,inner1
                        ,inner2,inner3,width,height,mb);

            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MaximizeVersion1.stopped = true;
                MaximizeVersion2.stopped = true;
                MaximizeVersion3.stopped = true;

                frame.getContentPane().removeAll();
                frame.repaint();
                frame.getContentPane().add(BorderLayout.SOUTH, panel);
            }
        });
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MaximizeVersion1.pause = true;
                MaximizeVersion2.pause = true;
                MaximizeVersion3.pause = true;
            }
        });

        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MaximizeVersion1.pause = false;
                MaximizeVersion2.pause = false;
                MaximizeVersion3.pause = false;
            }
        });
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setVisible(true);
    }

    static void update(JFrame frame,JPanel panel,JDesktopPane desktop,JInternalFrame inner1
    ,JInternalFrame inner2,JInternalFrame inner3,int width,int height,JMenuBar mb){
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        desktop = new JDesktopPane();
        desktop.setBounds(0, 0, 400, 900);

        inner1 = new JInternalFrame("Roulette wheel selection - Crossover1 ");
        inner1.setBounds(10, 30, width, height);
        MaximizeVersion1.plot = new Plot(MaximizeVersion1.population.individuals.length, MaximizeVersion1.population.individuals);
        inner1.add(MaximizeVersion1.plot);
        inner1.setVisible(true);

        inner2 = new JInternalFrame("Rank selection - Crossover2");
        inner2.setBounds(410, 30, width, height);
        MaximizeVersion2.plot = new Plot(MaximizeVersion2.population.individuals.length, MaximizeVersion2.population.individuals);
        inner2.add(MaximizeVersion2.plot);
        inner2.setVisible(true);

        inner3 = new JInternalFrame("Tournament selection - Crossover 1");
        inner3.setBounds(810, 30, width, height);
        MaximizeVersion3.plot = new Plot(MaximizeVersion3.population.individuals.length, MaximizeVersion3.population.individuals);
        inner3.add(MaximizeVersion3.plot);
        inner3.setVisible(true);

        desktop.add(inner1);
        desktop.add(inner2);
        desktop.add(inner3);
        frame.add(desktop);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setVisible(true);
    }
}
