class Population {
    /**
     * Individual list
     */
    Individual[] individuals;
    /**
     * the most fitness
     */
    double fittest = 0;

    /**
     * Initialize population
     * @param size size of population
     */
    public void initializePopulation(int size) {
        individuals = new Individual[size];
        for (int i = 0; i < size; i++) {
            individuals[i] = new Individual();
        }
    }

    /**
     * Get the fittest individual
     * @return the most fitness
     */
    public Individual getFittest() {
        double maxFit = Double.MIN_VALUE;


        int maxFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (maxFit <= individuals[i].fitness) {
                maxFit = individuals[i].fitness;
                maxFitIndex = i;
            }
        }
        fittest = individuals[maxFitIndex].fitness;
        return individuals[maxFitIndex];
    }

    /**
     * Get index of least fittest individual
     * @return least fitness individual
     */
    public int getLeastFittestIndex() {
        double minFitVal = Double.MAX_VALUE;
        int minFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (minFitVal >= individuals[i].fitness) {
                minFitVal = individuals[i].fitness;
                minFitIndex = i;
            }
        }
        return minFitIndex;
    }

    /**
     * Calculate fitness of each individual
     */
    public void calculateFitness() {

        for (int i = 0; i < individuals.length; i++) {
            individuals[i].calcFitness();
        }
    }

}