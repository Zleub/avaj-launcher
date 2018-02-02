package fr._42.adebray.simulator;

public class WeatherProvider {
  private static WeatherProvider weatherProvider = new WeatherProvider();
  private static String[] weather = {
    "RAIN", "FOG", "SUN", "SNOW"
  };
  private static java.util.Random r = new java.util.Random();
  private static int[] map;
  static {
    map = new int[4096];
    for (int i = 0; i < 4096; i++) {
      map[i] = r.nextInt(weather.length);
    }
  }

  private WeatherProvider() {}
  public static WeatherProvider getProvider() {
    return WeatherProvider.weatherProvider;
  }

  public String getCurrentWeather(Coordinates coordinates) {
    int i = (coordinates.getLongitude() * coordinates.getLatitude() + coordinates.getHeight()) % 4096 ;
    return WeatherProvider.weather[ map[i] ];
  }
}
