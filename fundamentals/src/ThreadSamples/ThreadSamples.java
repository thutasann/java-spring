package ThreadSamples;

/**
 * Main Class for Thread in Java Samples and Usages
 */
public class ThreadSamples {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("==> Thread Samples");

        TimerTaskSample timerTaskSample = new TimerTaskSample();
        timerTaskSample.SampleOne();

        ThreadUsages threadUsages = new ThreadUsages();
        threadUsages.SampleOne();
        // threadUsages.ThreadSleepSample();
        threadUsages.MyThreadSample();
    }

}
