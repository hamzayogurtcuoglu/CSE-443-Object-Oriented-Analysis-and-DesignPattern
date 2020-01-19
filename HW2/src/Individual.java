import java.util.Random;

/**
 * Individual class
 */
class Individual {
    /**
     * Individual fitness
     */
    double fitness = 0;
    /**
     * That keeps x1 and x2
     */
    double[] genes = new double[2];
    /**
     * That for rank selection
     */
    int rank;

    /**
     * x1 + x2 ⩽5 ; 0⩽ x1 ⩽5; 0⩽ x2 ⩽5
     * initialize the genes of individual
     */
    public Individual() {
        Random rand = new Random();
        genes[0] = (rand.nextDouble()*5+1)%5;
        do {
            genes[1] = (rand.nextDouble()*5+1)%5;

        }while (genes[1]+genes[0]>5);
        fitness = 0;
    }

    /**
     * Calculating fitness of individual
     * f (x1,x2)=20x1x2 +16x2 − 2x1^2 − x2^2 − (x1 + x2)^2
     */
    //Calculate fitness
    public void calcFitness() {
        fitness = 0;
        fitness = (20*genes[0]*genes[1] + 16*genes[1]
                - 2*(genes[0]*genes[0])
                -(genes[1]*genes[1])
                -(genes[0]+genes[1])*(genes[0]+genes[1])
        );
    }

}
