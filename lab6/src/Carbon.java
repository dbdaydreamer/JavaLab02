package src;

interface CarbonFootprint {
    double getCarbonFootprint();
}

class Building implements CarbonFootprint {
    private String address;
    private String name;
    private double electricityUsed;
    private double gasUsed;

    public Building(String address, String name, double electricityUsed, double gasUsed) {
        this.address = address;
        this.name = name;
        this.electricityUsed = electricityUsed;
        this.gasUsed = gasUsed;
    }

    @Override
    public double getCarbonFootprint() {
        return electricityUsed * 0.000233 + gasUsed * 2.0;
    }

    public String getInfo() {
        return "Building: " + address + " (" + name + ")";
    }
}

class Car implements CarbonFootprint {
    private String model;
    private double fuelUsed;

    public Car(String model, double fuelUsed) {
        this.model = model;
        this.fuelUsed = fuelUsed;
    }

    @Override
    public double getCarbonFootprint() {
        return fuelUsed * 2.31;
    }

    public String getInfo() {
        return "Car: " + model;
    }
}

class Airplane implements CarbonFootprint {
    private String name;
    private double distanceInKilometers;
    private double emissionFactorPerKilometer;
    private int numberOfPassengers;

    public Airplane(String name, double distanceInKilometers, double emissionFactorPerKilometer, int numberOfPassengers) {
        this.name = name;
        this.distanceInKilometers = distanceInKilometers;
        this.emissionFactorPerKilometer = emissionFactorPerKilometer;
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public double getCarbonFootprint() {
        return (emissionFactorPerKilometer * distanceInKilometers) / numberOfPassengers;
    }

    public String getInfo() {
        return "Airplane: " + name;
    }
}

class Main {
    public static void main(String[] args) {
        Building building = new Building("str. Tighina", "Caminul", 5000, 300);
        Car car = new Car("Tesla", 1200);
        Airplane airplane = new Airplane("Boeing 123", 15000, 3.1, 180);

        System.out.printf("%s | Carbon footprint: %.2f\n", building.getInfo(), building.getCarbonFootprint());
        System.out.printf("%s | Carbon footprint: %.2f\n", car.getInfo(), car.getCarbonFootprint());
        System.out.printf("%s | Carbon footprint: %.2f\n", airplane.getInfo(), airplane.getCarbonFootprint());
    }
}
