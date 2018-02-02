class AircraftFactory {
  public static Flyable newAircraft(
    String type,
    String name,
    int longitude,
    int latitude,
    int height
  ) throws Exception {
      Class<?> c = Class.forName(type);

       return (Flyable)c.getDeclaredConstructor(String.class, Coordinates.class)
         .newInstance(name, new Coordinates(longitude, latitude, height));
  }
}
