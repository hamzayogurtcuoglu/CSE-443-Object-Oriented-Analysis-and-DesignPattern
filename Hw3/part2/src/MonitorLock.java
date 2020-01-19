public class MonitorLock extends Thread{
    int order = 0;
    static ComplexNumber[][] result = new ComplexNumber[ControllerView.matrixSize][ControllerView.matrixSize];;
    static int threadNumber = 0;
    static int processNO;

    /**
     * Monitor , Mutex Lock Implementation
     */
    public  void run(){
        if (ControllerView.threadNumber == 2){
            if (order == 0)
                sum(0,0,ControllerView.matrixSize/2,ControllerView.matrixSize);
            else
                sum(ControllerView.matrixSize/2,0,ControllerView.matrixSize,ControllerView.matrixSize);
        }else if (ControllerView.threadNumber == 4){
            if (order == 0)
                sum(0,0,ControllerView.matrixSize/2,ControllerView.matrixSize/2);
            else if (order == 1)
                sum(0,ControllerView.matrixSize/2,ControllerView.matrixSize/2,ControllerView.matrixSize);
            else if (order == 2)
                sum(ControllerView.matrixSize/2,0,ControllerView.matrixSize,ControllerView.matrixSize/2);
            else
                sum(ControllerView.matrixSize/2,ControllerView.matrixSize/2,ControllerView.matrixSize,ControllerView.matrixSize);
        }else{
            if (order == 0)
                sum(0,0,ControllerView.matrixSize/2,ControllerView.matrixSize/4);
            else if (order == 1)
                sum(0,ControllerView.matrixSize/4,ControllerView.matrixSize/2,2*ControllerView.matrixSize/4);
            else if (order == 2)
                sum(0,2*ControllerView.matrixSize/4,ControllerView.matrixSize/2,3*ControllerView.matrixSize/4);
            else if (order == 3)
                sum(0,3*ControllerView.matrixSize/4,ControllerView.matrixSize/2,ControllerView.matrixSize);
            else if (order == 4)
                sum(ControllerView.matrixSize/2,0,ControllerView.matrixSize,ControllerView.matrixSize/4);
            else if (order == 5)
                sum(ControllerView.matrixSize/2,ControllerView.matrixSize/4,ControllerView.matrixSize,2*ControllerView.matrixSize/4);
            else if (order == 6)
                sum(ControllerView.matrixSize/2,2*ControllerView.matrixSize/4,ControllerView.matrixSize,3*ControllerView.matrixSize/4);
            else
                sum(ControllerView.matrixSize/2,3*ControllerView.matrixSize/4,ControllerView.matrixSize,ControllerView.matrixSize);
        }

            threadNumber++;
            synchronized (result) {
                if (threadNumber != ControllerView.threadNumber) {
                    try {
                        result.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    result.notifyAll();
                }
            }

        if (ControllerView.threadNumber == 2){
            if (order == 0) {
                try {
                    (new DFT()).transform(0,0,ControllerView.matrixSize/2,ControllerView.matrixSize,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    (new DFT()).transform(ControllerView.matrixSize/2,0,ControllerView.matrixSize,ControllerView.matrixSize,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else if (ControllerView.threadNumber == 4){
            if (order == 0) {
                try {
                    (new DFT()).transform(0,0,ControllerView.matrixSize/2,ControllerView.matrixSize/2,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (order == 1) {
                try {
                    (new DFT()).transform(0,ControllerView.matrixSize/2,ControllerView.matrixSize/2,ControllerView.matrixSize,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (order == 2) {
                try {
                    (new DFT()).transform(ControllerView.matrixSize/2,0,ControllerView.matrixSize,ControllerView.matrixSize/2,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    (new DFT()).transform(ControllerView.matrixSize/2,ControllerView.matrixSize/2,ControllerView.matrixSize,ControllerView.matrixSize,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            if (order == 0) {
                try {
                    (new DFT()).transform(0,0,ControllerView.matrixSize/2,ControllerView.matrixSize/4,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (order == 1) {
                try {
                    (new DFT()).transform(0,ControllerView.matrixSize/4,ControllerView.matrixSize/2,2*ControllerView.matrixSize/4,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (order == 2) {
                try {
                    (new DFT()).transform(0,2*ControllerView.matrixSize/4,ControllerView.matrixSize/2,3*ControllerView.matrixSize/4,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (order == 3) {
                try {
                    (new DFT()).transform(0,3*ControllerView.matrixSize/4,ControllerView.matrixSize/2,ControllerView.matrixSize,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (order == 4) {
                try {
                    (new DFT()).transform(ControllerView.matrixSize/2,0,ControllerView.matrixSize,ControllerView.matrixSize/4,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (order == 5) {
                try {
                    (new DFT()).transform(ControllerView.matrixSize/2,ControllerView.matrixSize/4,ControllerView.matrixSize,2*ControllerView.matrixSize/4,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (order == 6) {
                try {
                    (new DFT()).transform(ControllerView.matrixSize/2,2*ControllerView.matrixSize/4,ControllerView.matrixSize,3*ControllerView.matrixSize/4,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    (new DFT()).transform(ControllerView.matrixSize/2,3*ControllerView.matrixSize/4,ControllerView.matrixSize,ControllerView.matrixSize,result,processNO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        threadNumber=0;
    }
    synchronized public void start(int order,int processNO){
        MonitorLock.processNO = processNO;
        this.order = order;
        start();
    }

    /**
     * 2D 2 matrix is summed
     * @param startRow each thread is worked from its own row
     * @param startColumn each thread is worked from its own column
     * @param endRow each thread is worked to its own row
     * @param endColumn each thread worked to its own column
     */
    void sum(int startRow,int startColumn,int endRow,int endColumn){
        for (int i = startRow;i<endRow;i++)
            for (int j = startColumn;j<endColumn;j++)
                result[i][j] = new ComplexNumber(ControllerView.A[i][j].real + ControllerView.B[i][j].real,
                        ControllerView.A[i][j].img + ControllerView.B[i][j].img);
    }
}
