/**
 * we keep operation through this class.
 */
public class linearContext {
    /**
     * This linearStrategy references a selected operation.
     */
    public linearStrategy doLinearOperationObject;

    /**
     * gets a operation for its reference
     * @param doLinearOperation
     */
    public linearContext(linearStrategy doLinearOperation) {
        this.doLinearOperationObject = doLinearOperation;
    }

    /**
     * This method is doing which operation is selected.
     * @param coefficients user is writing coefficients Ex: 2.x1 etc.
     * @param variables unknown variables.
     * @return result of operation is return such as array.
     */
    public double[] doOperation(double[][] coefficients, double[] variables) {
        return this.doLinearOperationObject.doLinearOperation(coefficients,variables);
    }
}
