class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        setPassengerCapacity(passengerCapacity);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < 10 || passengerCapacity > 100) {
            throw new IllegalArgumentException("Passenger capacity must be between 10 and 100");
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        int age = getAge(2026);
        double baseFee = getBasePrice() * 0.05;
        double ageFee = getBasePrice() * 0.01 * age;
        double capacityFee = passengerCapacity * 10;
        return baseFee + ageFee + capacityFee;
    }

    @Override
    public void performService() {
        System.out.println(">>> Performing BUS service for " + getModel() +
                ": Engine check, transmission service, safety systems inspection, " +
                "passenger area cleaning completed.");
    }

    @Override
    public int getServiceIntervalKm() {
        return 15000;
    }

    @Override
    public String toString() {
        return "BUS - " + super.toString() +
                String.format(", Capacity: %d passengers, Insurance Fee: $%.2f",
                        passengerCapacity, calculateInsuranceFee());
    }
}
