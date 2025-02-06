package KeyPatterns.SlidingWindow;

public class MinMaxExample {
    public static void Examples() {
        basic();
        findingSmallerLarger();
        dailyTempleratureMonitoring();
        keepingValueWithinRange();
        comparingTransactionLimits();
        gamingHealh();
    }

    private static void gamingHealh() {
        System.out.println("\n(Min Max) Gaming Health ==> ");
        int health = 90, maxHealth = 100;
        health = Math.min(health + 20, maxHealth);
        System.out.println("Current Health ==> " + health);
    }

    private static void comparingTransactionLimits() {
        System.out.println("\n(Min Max) Comparing Transation Limits ==> ");
        double withdrawAmount = 500.0, balance = 300.0;
        double maxWithdraw = Math.max(withdrawAmount, balance);
        System.out.println("Allowed withdrawal: $" + maxWithdraw);
    }

    private static void keepingValueWithinRange() {
        System.out.println("\n(Min Max) Keeping value within range ==> ");
        int value = 120, min = 0, max = 100;
        int clampedValue = Math.max(min, Math.min(value, max));
        System.out.println("clampedValue ==> " + clampedValue);
    }

    private static void dailyTempleratureMonitoring() {
        System.out.println("\n(Min Max) Daily Temperature Monitoring ==> ");
        double templ1 = 18.5, temp2 = 22.1;
        double lowest = Math.min(templ1, temp2);
        double highest = Math.max(templ1, temp2);
        System.out.println("Lowest temp : " + lowest);
        System.out.println("Highest temp : " + highest);
    }

    private static void findingSmallerLarger() {
        System.out.println("\n(Min Max) Finding the Smaller/Larger Number in a List ==> ");
        int[] numbers = { 15, 3, 7, 22, 10 };
        int minVal = numbers[0], maxVal = numbers[0];
        for (int num : numbers) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }
        System.out.println("Min: " + minVal + ", Max: " + maxVal);
    }

    private static void basic() {
        System.out.println("\n(Min Max) basic Usage ==> ");
        int a = 10, b = 20;
        System.out.println(Math.min(a, b));
        System.out.println(Math.max(a, b));
    };
}
