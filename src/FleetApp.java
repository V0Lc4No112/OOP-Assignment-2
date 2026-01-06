import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FleetApp {
    private List<Vehicle> vehicles;
    private Scanner scanner;

    public FleetApp() {
        vehicles = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (choice) {
                    case 1:
                        printAllVehicles();
                        break;
                    case 2:
                        addNewCar();
                        break;
                    case 3:
                        addNewBus();
                        break;
                    case 4:
                        showTotalInsuranceFees();
                        break;
                    case 5:
                        showVehiclesOlderThanN();
                        break;
                    case 6:
                        performServiceForAll();
                        break;
                    case 7:
                        System.out.println("Thank you for using Fleet Management System. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("         FLEET MANAGEMENT SYSTEM");
        System.out.println("=".repeat(50));
        System.out.println("1. Print all vehicles");
        System.out.println("2. Add new car");
        System.out.println("3. Add new bus");
        System.out.println("4. Show total yearly insurance fees");
        System.out.println("5. Show vehicles older than N years");
        System.out.println("6. Perform service for all vehicles");
        System.out.println("7. Quit");
        System.out.println("=".repeat(50));
    }

    private void printAllVehicles() {
        System.out.println("--- ALL VEHICLES IN FLEET ---");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
            System.out.println("\nTotal vehicles: " + vehicles.size());
        }
    }

    private void addNewCar() {
        System.out.println("--- ADD NEW CAR ---");

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter base price: ");
        double basePrice = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter number of doors (2-5): ");
        int numberOfDoors = Integer.parseInt(scanner.nextLine());

        Car car = new Car(model, year, basePrice, numberOfDoors);
        vehicles.add(car);

        System.out.println("\n✓ Car added successfully!");
        System.out.println(car);

        Serviceable servicable = car;
        System.out.println("Service interval: " + servicable.getServiceIntervalKm() + " km");
    }

    private void addNewBus() {
        System.out.println("--- ADD NEW BUS ---");

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter base price: ");
        double basePrice = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter passenger capacity (10-100): ");
        int passengerCapacity = Integer.parseInt(scanner.nextLine());

        Bus bus = new Bus(model, year, basePrice, passengerCapacity);
        vehicles.add(bus);

        System.out.println("\n✓ Bus added successfully!");
        System.out.println(bus);

        Serviceable servicable = bus;
        System.out.println("Service interval: " + servicable.getServiceIntervalKm() + " km");
    }

    private void showTotalInsuranceFees() {
        System.out.println("--- TOTAL YEARLY INSURANCE FEES ---");

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
            return;
        }

        double totalFees = 0;
        for (Vehicle vehicle : vehicles) {
            double fee = vehicle.calculateInsuranceFee();
            System.out.printf("%s - Insurance: $%.2f%n", vehicle.getModel(), fee);
            totalFees += fee;
        }

        System.out.println("-".repeat(40));
        System.out.printf("TOTAL YEARLY INSURANCE FEES: $%.2f%n", totalFees);
    }

    private void showVehiclesOlderThanN() {
        System.out.println("--- VEHICLES OLDER THAN N YEARS ---");

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
            return;
        }

        System.out.print("Enter current year: ");
        int currentYear = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter N (minimum age in years): ");
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println("\nVehicles older than " + n + " years:");
        boolean found = false;

        for (Vehicle vehicle : vehicles) {
            int age = vehicle.getAge(currentYear);
            if (age > n) {
                System.out.printf("%s (Age: %d years)%n", vehicle, age);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found older than " + n + " years.");
        }
    }

    private void performServiceForAll() {
        System.out.println("--- PERFORM SERVICE FOR ALL VEHICLES ---");

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
            return;
        }

        System.out.println("Starting service operations...\n");

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Serviceable) {
                Serviceable servicable = (Serviceable) vehicle;
                servicable.performService();
            }
        }

        System.out.println("\n✓ All vehicles serviced successfully!");
    }

    public static void main(String[] args) {
        FleetApp app = new FleetApp();
        app.run();
    }
}