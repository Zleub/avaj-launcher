public class Helicopter extends Aircraft implements Flyable {
  private static java.util.TreeMap<String, int[]> changes;
  private static java.util.TreeMap<String, String> messages;
  static {
      changes = new java.util.TreeMap<String, int[]>();
      changes.put("SUN",  new int[]{ 10, 0,   2 } );
      changes.put("RAIN", new int[]{  5, 0,   0 } );
      changes.put("FOG",  new int[]{  1, 0,   0 } );
      changes.put("SNOW", new int[]{  0, 0, -12 } );

      messages = new java.util.TreeMap<String, String>();
      messages.put("SUN",  "Yay, it's sunny again !" );
      messages.put("RAIN", "Yay, it's rainy again !" );
      messages.put("FOG",  "Yay, it's foggy again !" );
      messages.put("SNOW", "Yay, it's snowy again !" );
  }

  private WeatherTower weatherTower;

  public Helicopter(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  public void updateConditions() {
    try {
      super.updateConditions(this.weatherTower, this.changes, this.messages);
    } catch (Exception e) {
      this.weatherTower.unregister(this);
    }
  }

  public void registerTower(WeatherTower wt) {
    this.weatherTower = wt;
    wt.register(this);
  }

  // public String toString() {
  //   return "Helicopter";
  // }
}
