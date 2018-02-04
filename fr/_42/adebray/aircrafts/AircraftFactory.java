package fr._42.adebray.aircrafts;

import fr._42.adebray.simulator.Flyable;
import fr._42.adebray.simulator.Coordinates;

public class AircraftFactory {
  public static Flyable newAircraft(
    String type,
    String name,
    int longitude,
    int latitude,
    int height
  ) throws Exception {
      Class<?> c = Class.forName("fr._42.adebray.aircrafts." + type);

       return (Flyable)c.getDeclaredConstructor(String.class, Coordinates.class)
         .newInstance(name, new Coordinates(longitude, latitude, height));
  }
}
