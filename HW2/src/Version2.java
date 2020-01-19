import java.util.Random;
import java.util.Scanner;

public class Version2 extends GenericAlgorithm {
    /**
     * Rank selection
     */
    @Override
    void selection() {

        int totalRank = (population.individuals.length)*(population.individuals.length+1)/2;

        boolean sorted = false;
        Individual temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < population.individuals.length - 1; i++) {
                if (population.individuals[i].fitness > population.individuals[i+1].fitness) {
                    temp = population.individuals[i];
                    population.individuals[i] = population.individuals[i+1];
                    population.individuals[i+1] = temp;
                    sorted = false;
                }
            }
        }
        for (int i=0;i<population.individuals.length;i++){
            population.individuals[i].rank = i + 1;
        }
        Random rand = new Random();
        int random = rand.nextInt(totalRank)+1;
        int interval1 = 0;
        int interval2 = 0;
        for (int i = 0; i < population.individuals.length; i++) {
            interval1 += population.individuals[i].rank;
            if (interval1>=random && interval2<=random) {
                parent1 = population.individuals[i];
                break;
            }
            interval2 += population.individuals[i].rank;
        }

        random = rand.nextInt(totalRank)+1;
        interval1 = 0;
        interval2 = 0;
        int i = 0;

        while (i < population.individuals.length) {
            interval1 += population.individuals[i].rank;
            if ( interval1>=random && interval2<=random
                    &&population.individuals[i] == parent1){
                i = 0;
                random = rand.nextInt(totalRank)+1;
                interval1 = 0;
                interval2 = 0;
                continue;
            }
            else if (interval1>=random && interval2<=random) {
                parent2 = population.individuals[i];
                break;
            }
            interval2 += population.individuals[i].rank;
            i++;
        }
    }

    /**
     * 2 Point crossover
     */
    @Override
    void crossover() {
        Random rn = new Random();

        child = new Individual();
        child.genes[0] = (parent1.genes[0]+parent2.genes[0]) /2;
        child.genes[1] = (parent1.genes[1]+parent2.genes[1]) /2;
    }
}
