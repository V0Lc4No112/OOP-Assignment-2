abstract class Vehicle implements Serviceable {
    private int id;
    private static int idGen = 1;
    private String model;
    private int year;
    private double basePrice;

    // Constructor
    protected Vehicle(String model, int year, double basePrice) {
        this.id = idGen++;
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getBasePrice() {
        return basePrice;
    }

    // Setters with validation
    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty");
        }
        this.model = model;
    }

    public void setYear(int year) {
        if (year < 1886 || year > 2030) { // First car was invented in 1886
            throw new IllegalArgumentException("Year must be between 1886 and 2030");
        }
        this.year = year;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be greater than 0");
        }
        this.basePrice = basePrice;
    }

    // Calculate vehicle age
    public int getAge(int currentYear) {
        return currentYear - year;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return String.format("ID: %d, Model: %s, Year: %d, Base Price: $%.2f",
                id, model, year, basePrice);
    }
}
