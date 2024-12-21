package ThreadSamples;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskSample {
    public void SampleOne() {
        System.out.println("\n===> Timer Task Sample One");

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task is complete (Sample One)!");
            }
        };
        timer.schedule(task, 0);
    }

    public void SampleTwo() {
        System.out.println("\n===> Timer Task Sample Two");

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task is complete!");
            }
        };

        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 2024);
        date.set(Calendar.MONDAY, Calendar.DECEMBER);
        date.set(Calendar.DAY_OF_MONTH, 22);
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        timer.schedule(task, date.getTime());
    }
}
