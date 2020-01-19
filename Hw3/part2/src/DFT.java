public class DFT {
    static ComplexNumber[][] result = new ComplexNumber[ControllerView.matrixSize][ControllerView.matrixSize];;

    /**
     * Calculates Discrete Fourier Transformation of given 2d array.
     * input array to calculate transformation
     * https://en.wikipedia.org/wiki/Discrete_Fourier_transform
     * @param startRow each thread is worked from its own row
     * @param startColumn each thread is worked from its own column
     * @param endRow each thread is worked to its own row
     * @param endColumn each thread worked to its own column
     * @param resultSum that parameter is result of 2D matrix sum result
     * @param processNO process id
     * @throws InterruptedException
     */
    synchronized void transform(int startRow, int startColumn,
                                int endRow, int endColumn, ComplexNumber[][] resultSum, int processNO) throws InterruptedException {
        int n = ControllerView.matrixSize;
        int sumReal = 0;
        int sumImag = 0;
        for (int i = startRow; i < endRow; i++) {
            for (int j = startColumn;j<endColumn;j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        double angle = 2 * Math.PI * (i*n + j) * (k*n + l) / n*n;
                        sumReal += resultSum[k][l].real * Math.cos(angle)
                                + resultSum[k][l].img* Math.sin(angle);
                        sumImag += -resultSum[k][l].real * Math.sin(angle)
                                + resultSum[k][l].img * Math.cos(angle);
                        if (processNO != ControllerView.processNO){
                            wait();
                        }
                    }
                }
                result[i][j] = new ComplexNumber(sumReal,sumImag);
            }
        }
    }
}
