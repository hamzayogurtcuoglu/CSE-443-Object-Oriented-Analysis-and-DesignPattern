import java.util.Random;

public class Version3 extends GenericAlgorithm {
    /**
     * Tournament selection
     */
    @Override
    void selection() {
        Random rand = new Random();
        for (int i = 0;i < population.individuals.length;i++){
        }

        Individual [] tournament = new Individual[2];
        tournament[0] = population.individuals[rand.nextInt(population.individuals.length)];
        tournament[1] = population.individuals[rand.nextInt(population.individuals.length)];
        if (tournament[1].fitness<tournament[0].fitness) {
            parent1 = tournament[0];
        }else{
            parent1 = tournament[1];
        }
        Individual [] tournament2 = new Individual[2];
        do {
            tournament2[0] = population.individuals[rand.nextInt(population.individuals.length)];
            tournament2[1] = population.individuals[rand.nextInt(population.individuals.length)];
            if (tournament2[1].fitness<tournament2[0].fitness) {
                parent2 = tournament2[0];
            }else{
                parent2 = tournament2[1];
            }
        }while (tournament2[0].fitness==parent1.fitness || tournament2[1].fitness==parent1.fitness  );
    }

    /**
     * 1 Point Crossover
     */
    @Override
    void crossover() {
        Random rn = new Random();
        child = new Individual();
        child.genes[0] = (parent1.genes[0]+parent2.genes[0])/2;
        do {
            child.genes[1] = (rn.nextDouble()*5+1)%5;
        }while (child.genes[1]+child.genes[0]>5);
    }
}
