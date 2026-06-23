package financialforecasting;

public class Recursion {
    public static float getFutureRate(int year, float currVal, int currYear, float g) {
        if(year == currYear)
            return currVal;
        return getFutureRate(year-1, currVal, currYear, g) * (1+g);
    }
    public static void main(String[] args) {
        System.out.println(getFutureRate(2031, 3261, 2026, 0.1f)); //considering 0.1 as past growth rate
    }
}