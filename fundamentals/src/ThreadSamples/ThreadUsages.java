package ThreadSamples;

public class ThreadUsages {
    public void SampleOne() {
        System.out.println("\n===> Thread Usage Sample One ");

        System.out.println("Thread Active Count --> " + Thread.activeCount());

        Thread.currentThread().setName("MAINNNNNN");

        System.out.println("Current Thread Name --> " + Thread.currentThread().getName());

        System.out.println("Current Thread Priority --> " + Thread.currentThread().getPriority());

        System.out.println("Is Alive ? --> " + Thread.currentThread().isAlive());
    }

    public void ThreadSleepSample() throws InterruptedException {
        System.out.println("\n===> Thread Sleep Sample");

        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("Thread sleep done!");
    }

    public void MyThreadSample() {
        System.out.println("\n===> My Thread Sample");
        MyThread myThread = new MyThread();

        myThread.start();

        System.out.println("myThread is alive --> " + myThread.isAlive());

        myThread.setName("MY_THREAD");

        System.out.println("myThread name --> " + myThread.getName());

        System.out.println("myThread priority --> " + myThread.getPriority());
    }
}
