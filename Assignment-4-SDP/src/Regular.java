public class Regular implements FareStrategy {
    public double calculateFare(double distance, double duration) {
        return (1.00 * distance) + (0.25 * duration);
    }
}

