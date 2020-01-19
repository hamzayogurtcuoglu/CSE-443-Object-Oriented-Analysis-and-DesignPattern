
import java.io.*;
import java.util.Random;

/**
 * Its subclasses can override the method implementation as per need but
 * the invocation is to be in the same way as defined by an abstract class.
 * This pattern comes under behavior pattern category.
 */
public abstract class GenericAlgorithm extends Thread{

    File fileWriter;
    /**
     * That is for stop button
     */
    boolean stopped  =false;
    /**
     * That is for pause button
     */
    boolean pause = false;
    /**
     * That keeps all individuals
     */
    Population population = new Population();
    /**
     * that keeps selected a parent
     */
    Individual parent1;
    /**
     * This variable keeps other parent.
     */
    Individual parent2;
    /**
     * Two parent produce a child.
     */
    Individual child;
    /**
     * That show fittest child generation
     */
    int generationCount = 0;
    /**
     * We can create 2D plot of fitness
     */
    String VersionName;
    Plot plot;

    public  final void run()
    {
        try
        {
            this.solveTemplateMethod();
        }
        catch (Exception e)
        {
            System.out.println ("Exception is caught");
        }
    }

    /**
     * There is a loop that continues until population has converged
     * @throws InterruptedException
     */
    public final void solveTemplateMethod() throws InterruptedException, IOException {
        Random rn = new Random();
        System.out.println("Generation: " + generationCount + " Fittest: " + population.getFittest().fitness);
        while (population.getFittest().fitness < 126) {
            ++generationCount;

            selection();
            crossover();
            if (rn.nextInt()%7 < 5) {
                mutation();
            }
            addFittestOffspring();
            population.calculateFitness();
            System.out.println("Version Name : " + VersionName);
            System.out.println("Generation: " + generationCount + " Fittest: " + population.getFittest().fitness);
            System.out.println("Genes " + population.getFittest().genes[0]
                    + "   "  + population.getFittest().genes[1]);
            if (stopped)
                break;
            for (;pause ==true&&stopped!=true;){
                System.out.println("You Paused !!! If you want to continue . Press run button.");
            }
        }

        System.out.println("\nVersion Name : " + VersionName);
        System.out.println("Solution found in generation " + generationCount);
        System.out.println("Fitness: "+population.getFittest().fitness);
        System.out.println("Genes: ");
        for (int i = 0; i < 2; i++) {
            System.out.println("        "+population.getFittest().genes[i]);
        }
        fileWriter = new File("LastFinishedOutput.txt");
        FileWriter fr = new FileWriter(fileWriter, true);
        BufferedWriter br = new BufferedWriter(fr);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("Version Name : " + VersionName);
        printWriter.println("Solution found in generation " + generationCount);
        printWriter.println("Fitness: "+population.getFittest().fitness);
        printWriter.println("Genes: ");
        for (int i = 0; i < 2; i++) {
            printWriter.printf("        "+population.getFittest().genes[i]);
        }
        printWriter.close();

    }

    /**
     * Concrete classes that extend GenericAlgorithm and override its methods.
     */
    abstract void  selection() ;

    /**
     * Concrete classes that extend GenericAlgorithm and override its methods.
     */
    abstract void crossover();

    /**
     * Mutation for child genes
     */
    void mutation() {
        Random rand = new Random();

        if (rand.nextInt(1)==1) {
            do {
                child.genes[0] = (rand.nextDouble()*5+1)%5;
            }while (child.genes[0]+child.genes[1]>5);
        }else{
            do {
                child.genes[1] = (rand.nextDouble()*5+1)%5;
            }while (child.genes[1]+child.genes[0]>5);
        }
    }

    /**
     * Replace least fittest individual from most fittest offspring
     */
    void addFittestOffspring() {
        int leastFittestIndex = population.getLeastFittestIndex();
        population.individuals[leastFittestIndex] =child;
    }
}


