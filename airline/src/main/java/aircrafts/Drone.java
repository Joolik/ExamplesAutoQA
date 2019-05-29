package aircrafts;

import java.util.Date;

// Беспилотники
public abstract class Drone extends Aircraft implements Rentable {

    public Drone(String id, String type, double flightRange, double maxLoad, int seatingCapacity) {
        super(id, type, flightRange, maxLoad, seatingCapacity);
    }

    public Drone(String id, String type, double flightRange, double maxLoad, int seatingCapacity, double cruiseSpeed, Date productionDate) {
        super(id, type, flightRange, maxLoad, seatingCapacity, cruiseSpeed, productionDate);
    }

    // Аренда беспилотника
    public void rent() {
        System.out.println("Drone: rent");
        status = AircraftStatuses.InFlight;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
