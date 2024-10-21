import java.time.LocalTime;

public class Rides {
    private FareStrategy fareStrategy;
    private static final double MINIMUM_FARE = 5.0;

    public Rides(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public void setFareStrategy(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public double calculateFare(double distance, double duration) {
        if (distance < 0 || duration < 0) {
            throw new IllegalArgumentException("Distance and duration must be non-negative.");
        }

        double baseFare = fareStrategy.calculateFare(distance, duration);
        double finalFare = applyTimeBasedMarkup(baseFare); // Time-based adjustment

        if (finalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        }

        return finalFare;
    }

    // Time-based markup implementation
    private double applyTimeBasedMarkup(double baseFare) {
        LocalTime currentTime = LocalTime.now();

        if (currentTime.isBefore(LocalTime.of(8, 0))) {
            return baseFare; // No markup between 00:00 - 08:00
        } else if (currentTime.isBefore(LocalTime.of(16, 0))) {
            return baseFare * 1.10; // 10% markup between 08:00 - 16:00
        } else {
            return baseFare * 1.30; // 30% markup between 16:00 - 23:59
        }
    }
}
