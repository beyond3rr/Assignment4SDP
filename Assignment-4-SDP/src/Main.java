public class Main {
    public static void main(String[] args) {
        Rides rideContext = new Rides(new Regular());

        System.out.println("Testing Regular Fare:");
        testFareCalculation(rideContext, 10, 15); // Example distance and duration

        rideContext.setFareStrategy(new Premium());
        System.out.println("\nTesting Premium Fare:");
        testFareCalculation(rideContext, 10, 15);

        rideContext.setFareStrategy(new Discount());
        System.out.println("\nTesting Discount Fare:");
        testFareCalculation(rideContext, 10, 15);

        rideContext.setFareStrategy(new Surge());
        System.out.println("\nTesting Surge Fare:");
        testFareCalculation(rideContext, 10, 15);
    }

    private static void testFareCalculation(Rides rideContext, double distance, double duration) {
        double fare = rideContext.calculateFare(distance, duration);
        System.out.println("Calculated Fare: $" + String.format("%.2f", fare));
    }
}
