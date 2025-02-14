package KeyPatterns.SlidingWindow.leetcodes.easy;

/**
 * Find the Highest Altitude
 * There is a biker going on a road trip. The road trip consists of n + 1 points
 * at different altitudes. The biker starts his trip on point 0 with altitude
 * equal 0.
 * 
 * You are given an integer array gain of length n where gain[i] is the net gain
 * in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the
 * highest altitude of a point.
 */
public class HighestAltitude {
    public static void main() {
        int[] gain = { -5, 1, 5, 0, -7 };
        System.out.println("\nHighest Altitude ==> " + largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int highestAltitude = 0;

        for (int netGain : gain) {
            currentAltitude += netGain;
            highestAltitude = Math.max(highestAltitude, currentAltitude);
        }
        return highestAltitude;
    }
}
