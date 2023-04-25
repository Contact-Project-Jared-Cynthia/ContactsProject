package utils;

public class RandomNumRange {
    public static int randomNum(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

}
