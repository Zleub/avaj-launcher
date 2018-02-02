package fr._42.adebray.simulator;

public class WeatherTower extends Tower {
  public String getWeather(Coordinates coordinates) {
    return WeatherProvider.getProvider().getCurrentWeather(coordinates);
  }

  protected void changeWeather() {
    this.conditionsChanged();
  }
}
