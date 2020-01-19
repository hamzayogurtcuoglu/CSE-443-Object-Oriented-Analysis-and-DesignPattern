
public class Test extends Thread{
    static ProxyBestDSEEver subObject;
    public static void main(String[] args) throws InterruptedException {

        subObject = new ProxyBestDSEEver();

        // Create producer thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                for (int i = 0;i<10;i++) {
                    subObject.add(i);
                }
            }
        });
        // Create consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                subObject.remove(2);
            }
        });

        // Create get thread
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("Got -> " + subObject.get(0));
            }
        });

        // Start both threads
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}