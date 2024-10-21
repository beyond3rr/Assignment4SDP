public class Discount implements FareStrategy {
    public double calculateFare(double distance, double duration) {
        return (0.80 * distance) + (0.20 * duration);
    }
}