public class operationGaussianElimination implements linearStrategy {

    /**
     * Calcute value of variables of equations with
     * gauss elimination operation
     * @param coefficient coefficient of equations variables
     * @param unknownVariables unknowsvariables
     * @return value of unknownvaraibles
     */
    @Override
    public double[] doLinearOperation(double[][] coefficient, double[] unknownVariables)  {
        int variableLength = unknownVariables.length;
        double[] solution = new double[variableLength];
        int maxLoca ;
        double[] temp ;
        double tempVariables;
        double item;
        for (int m = 0; m < variableLength; m++)
        {
            maxLoca = m;
            for (int i = m + 1; i < variableLength; i++)
                if (Math.abs(coefficient[i][m]) > Math.abs(coefficient[maxLoca][m]))
                    maxLoca = i;
             temp = coefficient[m];
             coefficient[m] = coefficient[maxLoca];
             coefficient[maxLoca] = temp;
             tempVariables = unknownVariables[m];
             unknownVariables[m] = unknownVariables[maxLoca];
             unknownVariables[maxLoca] = tempVariables;

            for (int i = m + 1; i < variableLength; i++)
            {
                item = coefficient[i][m] / coefficient[m][m];
                unknownVariables[i] -= item * unknownVariables[m];
                for (int j = m; j < variableLength; j++)
                    coefficient[i][j] -= item * coefficient[m][j];
            }
        }
        for (int i = variableLength - 1; i >= 0; i--)
        {
            double sum = 0.0;
            for (int j = i + 1; j < variableLength; j++)
                sum += coefficient[i][j] * solution[j];
            solution[i] = (unknownVariables[i] - sum) / coefficient[i][i];
        }
        return solution;
    }
}
