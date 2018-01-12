package ru.otus.l71.behavioral.mediator;

/**
 * Created by tully.
 * <p>
 * Producer and Consumer in the Mediator pattern.
 */
public interface Aircraft {
    void setControl(AirportControl control);

    /**
     * move the aircraft to the new sector
     *
     * @param sector new sector
     */
    void moveTo(int sector);

    /**
     * notify about new occupied sector
     *
     * @param sector occupied sector
     */
    void addDangerousSector(int sector);

    /**
     * notify about free sector
     *
     * @param sector free sector
     */
    void removeDangerousSector(int sector);

    /**
     * @return sector occupied by this aircraft
     */
    int getSector();
}
