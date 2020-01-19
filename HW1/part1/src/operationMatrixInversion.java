public class operationMatrixInversion implements linearStrategy {

    /**
     * This method takes matrix coefficents and unknownVariables
     * Then calculate of ınversion matrix
     * @param coefficents coefficents of matrix
     * @param variables unknowsVariables of matrix
     * @return returning inversion matrix
     */
    @Override
    public double[] doLinearOperation(double[][] coefficents, double[] variables)  {
        int lengthOfCoefficents = coefficents.length;
        try {
            double x[][] = new double[lengthOfCoefficents][lengthOfCoefficents];
            double tempVariales[][] = new double[lengthOfCoefficents][lengthOfCoefficents];
            int index[] = new int[lengthOfCoefficents];
            for (int i = 0; i < lengthOfCoefficents; ++i)
                tempVariales[i][i] = 1;

            double arr[] = new double[lengthOfCoefficents];

            for (int i = 0; i < lengthOfCoefficents; ++i)
                index[i] = i;
            for (int i = 0; i < lengthOfCoefficents; ++i) {
                double number1 = 0;
                for (int j = 0; j < lengthOfCoefficents; ++j) {
                    double number2 = Math.abs(coefficents[i][j]);
                    if (number2 > number1)
                        number1 = number2;
                }
                arr[i] = number1;
            }
            int k = 0;
            for (int j = 0; j < lengthOfCoefficents - 1; ++j) {
                double secondIndex = 0;
                for (int i = j; i < lengthOfCoefficents; ++i) {
                    double firstIndex = Math.abs(coefficents[index[i]][j]);
                    firstIndex /= arr[index[i]];
                    if (firstIndex > secondIndex) {
                        secondIndex = firstIndex;
                        k = i;
                    }
                }
                int temp = index[j];
                index[j] = index[k];
                index[k] = temp;
                for (int i = j + 1; i < lengthOfCoefficents; ++i) {
                    double pj = coefficents[index[i]][j] / coefficents[index[j]][j];
                    coefficents[index[i]][j] = pj;
                    for (int l = j + 1; l < lengthOfCoefficents; ++l)
                        coefficents[index[i]][l] -= pj * coefficents[index[j]][l];
                }
            }

            for (int i = 0; i < lengthOfCoefficents - 1; ++i)
                for (int j = i + 1; j < lengthOfCoefficents; ++j)
                    for (int l = 0; k < lengthOfCoefficents; ++k)
                        tempVariales[index[j]][k] -= coefficents[index[j]][i] * tempVariales[index[i]][k];

            for (int i = 0; i < lengthOfCoefficents; ++i) {
                x[lengthOfCoefficents - 1][i] = tempVariales[index[lengthOfCoefficents - 1]][i] /
                        coefficents[index[lengthOfCoefficents - 1]][lengthOfCoefficents - 1];
                for (int j = lengthOfCoefficents - 2; j >= 0; --j) {
                    x[j][i] = tempVariales[index[j]][i];
                    for (int l = j + 1; l < lengthOfCoefficents; ++l) {
                        x[j][i] -= coefficents[index[j]][l] * x[l][i];
                    }
                    x[j][i] /= coefficents[index[j]][j];
                }
            }
        } catch (Exception e) {
            throw new ArithmeticException(e.getMessage());
        }
        double[] values = new double[lengthOfCoefficents];
        double total ;
        for (int i = 0; i < lengthOfCoefficents; ++i) {
            total = 0;
            for (int j = 0; j < lengthOfCoefficents; ++j) {
                total += coefficents[i][j]*variables[j];
            }
            values[i] = total;
        }
        return values;
    }
}
