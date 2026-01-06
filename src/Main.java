import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   FLEET MANAGEMENT SYSTEM - DEMO     ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n" + "=".repeat(55));
            System.out.println("SELECT DEMONSTRATION MODE:");
            System.out.println("=".repeat(55));
            System.out.println("1. Run Full Fleet Management Application");
            System.out.println("2. Demo: Serviceable Interface & Polymorphism");
            System.out.println("3. Demo: Vehicle Abstract Class & Inheritance");
            System.out.println("4. Demo: Car Class Features");
            System.out.println("5. Demo: Bus Class Features");
            System.out.println("6. Exit");
            System.out.println("=".repeat(55));
            System.out.print("Enter your choice (1-6): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (choice) {
                    case 1:
                        runFleetApp();
                        break;
                    case 2:
                        demoServiceable();
                        break;
                    case 3:
                        demoVehicle();
                        break;
                    case 4:
                        demoCar();
                        break;
                    case 5:
                        demoBus();
                        break;
                    case 6:
                        System.out.println("Thank you! Goodbye.");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1-6.");
                }

                if (running && choice != 1) {
                    System.out.println("\n" + "=".repeat(55));
                    System.out.print("Press Enter to return to main menu...");
                    scanner.nextLine();
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Option 1: Run Full Application
    private static void runFleetApp() {
        System.out.println("Starting Fleet Management Application...\n");
        FleetApp app = new FleetApp();
        app.run();
    }

    // Option 2: Serviceable Interface Demo
    private static void demoServiceable() {
        System.out.println("=== SERVICEABLE INTERFACE DEMONSTRATION ===\n");
        System.out.println("The Serviceable interface defines contracts for service operations:");
        System.out.println("• performService() - executes service operations");
        System.out.println("• getServiceIntervalKm() - returns service interval\n");

        System.out.println("--- Creating Serviceable Objects ---");
        Car car = new Car("Honda Accord", 2020, 28000, 4);
        Bus bus = new Bus("Isuzu Novo Ultra", 2019, 85000, 30);

        System.out.println("✓ Car created: " + car.getModel());
        System.out.println("✓ Bus created: " + bus.getModel());

        System.out.println("\n--- Using Interface Methods (Polymorphism) ---");
        System.out.println("Car service interval: " + car.getServiceIntervalKm() + " km");
        car.performService();

        System.out.println("\nBus service interval: " + bus.getServiceIntervalKm() + " km");
        bus.performService();

        System.out.println("\n--- Polymorphic Array of Serviceable ---");
        Serviceable[] serviceableVehicles = {
                new Car("Mazda CX-5", 2022, 32000, 4),
                new Bus("Yutong ZK6128HQ", 2021, 95000, 45),
                new Car("Ford Explorer", 2020, 38000, 4)
        };

        for (int i = 0; i < serviceableVehicles.length; i++) {
            System.out.println("\nVehicle " + (i + 1) + ":");
            serviceableVehicles[i].performService();
            System.out.println("Next service in: " + serviceableVehicles[i].getServiceIntervalKm() + " km");
        }
    }

    // Option 3: Vehicle Abstract Class Demo
    private static void demoVehicle() {
        System.out.println("=== VEHICLE ABSTRACT CLASS DEMONSTRATION ===\n");
        System.out.println("Vehicle is an abstract class that:");
        System.out.println("• Cannot be instantiated directly");
        System.out.println("• Provides common fields and methods");
        System.out.println("• Defines abstract calculateInsuranceFee() method");
        System.out.println("• Implements Serviceable interface\n");

        System.out.println("--- Vehicle Array (Polymorphism) ---");
        Vehicle[] fleet = new Vehicle[4];
        fleet[0] = new Car("Toyota Corolla", 2019, 22000, 4);
        fleet[1] = new Bus("Scania Touring", 2020, 150000, 45);
        fleet[2] = new Car("BMW 3 Series", 2021, 42000, 4);
        fleet[3] = new Bus("Setra S 516 HD", 2018, 200000, 55);

        for (Vehicle vehicle : fleet) {
            System.out.println(vehicle);
        }

        System.out.println("\n--- Polymorphic Insurance Calculation ---");
        double totalInsurance = 0;
        for (Vehicle vehicle : fleet) {
            double fee = vehicle.calculateInsuranceFee();
            System.out.printf("%s: $%.2f%n", vehicle.getModel(), fee);
            totalInsurance += fee;
        }
        System.out.printf("Total Insurance: $%.2f%n", totalInsurance);

        System.out.println("\n--- Polymorphic Service Operations ---");
        for (Vehicle vehicle : fleet) {
            vehicle.performService();
        }
    }

    // Option 4: Car Class Demo
    private static void demoCar() {
        System.out.println("=== CAR CLASS DEMONSTRATION ===\n");

        Car car1 = new Car("Toyota Camry", 2020, 25000, 4);
        Car car2 = new Car("Honda Civic", 2015, 18000, 4);
        Car car3 = new Car("Ford Mustang", 2022, 35000, 2);

        System.out.println("--- Created Cars ---");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);

        System.out.println("\n--- Age Calculation ---");
        System.out.println(car1.getModel() + " age: " + car1.getAge(2026) + " years");
        System.out.println(car2.getModel() + " age: " + car2.getAge(2026) + " years");

        System.out.println("\n--- Insurance Fees ---");
        System.out.printf("%s: $%.2f%n", car1.getModel(), car1.calculateInsuranceFee());
        System.out.printf("%s: $%.2f%n", car2.getModel(), car2.calculateInsuranceFee());

        System.out.println("\n--- Service Operations ---");
        car1.performService();
        System.out.println("Service interval: " + car1.getServiceIntervalKm() + " km");
    }

    // Option 5: Bus Class Demo
    private static void demoBus() {
        System.out.println("=== BUS CLASS DEMONSTRATION ===\n");

        Bus bus1 = new Bus("Mercedes-Benz Sprinter", 2019, 55000, 25);
        Bus bus2 = new Bus("Volvo 9700", 2018, 120000, 50);
        Bus bus3 = new Bus("MAN Lion's Coach", 2021, 180000, 60);

        System.out.println("--- Created Buses ---");
        System.out.println(bus1);
        System.out.println(bus2);
        System.out.println(bus3);

        System.out.println("\n--- Age Calculation ---");
        System.out.println(bus1.getModel() + " age: " + bus1.getAge(2026) + " years");
        System.out.println(bus2.getModel() + " age: " + bus2.getAge(2026) + " years");

        System.out.println("\n--- Insurance Fees ---");
        System.out.printf("%s: $%.2f%n", bus1.getModel(), bus1.calculateInsuranceFee());
        System.out.printf("%s: $%.2f%n", bus2.getModel(), bus2.calculateInsuranceFee());
        System.out.printf("%s: $%.2f%n", bus3.getModel(), bus3.calculateInsuranceFee());

        System.out.println("\n--- Service Operations ---");
        bus1.performService();
        System.out.println("Service interval: " + bus1.getServiceIntervalKm() + " km");
    }
}