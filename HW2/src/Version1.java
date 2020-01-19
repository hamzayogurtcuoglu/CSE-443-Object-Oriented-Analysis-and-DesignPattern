import java.util.Random;

public class Version1 extends GenericAlgorithm {


    /**
     * Roulette wheel selection
     */
    @Override
    void selection() {

        double sum = 0;

        for (int i = 0; i < population.individuals.length; i++) {
            sum += population.individuals[i].fitness;
        }
        Random rand = new Random();
        double random = rand.nextDouble()*sum;

        double interval1 = 0;
        double interval2 = 0;
        for (int i = 0; i < population.individuals.length; i++) {
            interval1 += population.individuals[i].fitness;
            if (interval1>=random && interval2<=random ||
                    interval2>=random && interval1<=random) {
                parent1 = population.individuals[i];
                break;
            }
            interval2 += population.individuals[i].fitness;
        }

        random = rand.nextDouble()*sum;
        interval1 = 0;
        interval2 = 0;
        int i = 0;

        while (i < population.individuals.length) {
            interval1 += population.individuals[i].fitness;
            if ( (interval1>=random && interval2<=random||
                    interval2>=random && interval1<=random)
                    &&population.individuals[i] == parent1){

                i = 0;
                random = rand.nextDouble()*sum;
                interval1 = 0;
                interval2 = 0;
                continue;
            }
            else if (interval1>=random && interval2<=random||
                    interval2>=random && interval1<=random) {
                parent2 = population.individuals[i];
                break;
            }
            interval2 += population.individuals[i].fitness;
            i++;
        }

    }

    /**
     * 1 point crossover
     */
    @Override
    void crossover() {
        Random rn = new Random();

        child = new Individual();
        child.genes[0] = (parent1.genes[0]+parent2.genes[0]) /2;
        do {
            child.genes[1] = (rn.nextDouble()*5+1)%5;
        }while (child.genes[1]+child.genes[0]>5);
    }
}
