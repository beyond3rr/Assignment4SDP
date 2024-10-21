public class Premium implements FareStrategy {
    public double calculateFare(double distance, double duration) {
        return (2.00 * distance) + (0.50 * duration);
    }
}
