package ru.otus.l71.behavioral.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tully.
 * <p>
 * Mediator in the Mediator pattern.
 */
public class AirportControl {
    private Map<Aircraft, Integer> positions = new HashMap<>();

    /**
     * Message to all aircrafts
     *
     * @param aircraft which moved to a new sector
     */
    public void moved(Aircraft aircraft) {
        int previousSector = positions.get(aircraft);

        positions.forEach((key, value) -> {
            if (!key.equals(aircraft)) {
                key.removeDangerousSector(previousSector);
                key.addDangerousSector(aircraft.getSector());
            }
        });

        positions.put(aircraft, aircraft.getSector());
    }

    /**
     * store() method in Mediator pattern
     *
     * @param aircraft aricraft to store
     */

    public void addAircraft(Aircraft aircraft) {
        positions.forEach((key, value) -> {
            key.addDangerousSector(aircraft.getSector());
            aircraft.addDangerousSector(value);
        });

        positions.put(aircraft, aircraft.getSector());
    }
}
