package fr._42.adebray.aircrafts;

import fr._42.adebray.simulator.WeatherTower;
import fr._42.adebray.simulator.Coordinates;

public class Aircraft {
  protected long id;
  protected String name;
  protected Coordinates coordinates;

  static private long idCounter;

  protected Aircraft(String name, Coordinates coordinates) {
    this.name = name;
    this.coordinates = coordinates;
    this.id = (this.idCounter++);
  }

  public long getId() { return this.id; }
  public String getName() { return this.name; }

  protected void updateConditions(WeatherTower weathertower, java.util.TreeMap<String, int[]> changes, java.util.TreeMap<String, String> messages) throws Exception {
    String weather = weathertower.getWeather(this.coordinates);
    System.out.println(this + "\t" + messages.get(weather));
    // System.out.println(weather);

    try {
      this.coordinates = new Coordinates(
        this.coordinates.getLongitude() + changes.get(weather)[0],
        this.coordinates.getLatitude() + changes.get(weather)[1],
        this.coordinates.getHeight() + changes.get(weather)[2]
      );
    } catch (Exception e) {
      System.out.println(
        this.getClass().getSimpleName() + "#" + this.name + "[" + this.id + "] " + "Landing @ " +
        (this.coordinates.getLongitude() + changes.get(weather)[0]) + " " +
        (this.coordinates.getLatitude() + changes.get(weather)[1]) + " " +
        0
      );
      throw e;
    }
  }

  public String toString() {
    return this.getClass().getSimpleName() + "#" + this.name + "[" + this.id + "] " + this.coordinates;
  }
}
