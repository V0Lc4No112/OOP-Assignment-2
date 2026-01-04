class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        setNumberOfDoors(numberOfDoors);
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors < 2 || numberOfDoors > 5) {
            throw new IllegalArgumentException("Number of doors must be between 2 and 5");
        }
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        // Insurance formula for cars: base 2% of price + 0.5% per year of age
        int age = getAge(2026); // Using current year
        double baseFee = getBasePrice() * 0.02;
        double ageFee = getBasePrice() * 0.005 * age;
        return baseFee + ageFee;
    }

    @Override
    public void performService() {
        System.out.println(">>> Performing CAR service for " + getModel() +
                ": Oil change, tire rotation, brake inspection completed.");
    }

    @Override
    public int getServiceIntervalKm() {
        return 10000; // Cars serviced every 10,000 km
    }

    @Override
    public String toString() {
        return "CAR - " + super.toString() +
                String.format(", Doors: %d, Insurance Fee: $%.2f",
                        numberOfDoors, calculateInsuranceFee());
    }
}