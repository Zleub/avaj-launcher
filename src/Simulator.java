import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Simulator {
  public static void main(String[] args) {
    try {
      if (args.length == 1) {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        String line = in.readLine();
        int count = Integer.parseInt(line);

        String pattern = "(\\w+)\\s+(\\w+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)";
        Pattern r = Pattern.compile(pattern);

        WeatherTower wt = new WeatherTower();

        System.out.println("Here comes " + count + " weather changes");
        int i = 1;
        while ((line = in.readLine()) != null) {
          Matcher m = r.matcher(line);
          if ( m.find() ) {
            try {
              Flyable f = AircraftFactory.newAircraft(
                m.group(1),
                m.group(2),
                Integer.parseInt( m.group(3) ),
                Integer.parseInt( m.group(4) ),
                Integer.parseInt( m.group(5) )
              );

              f.registerTower(wt);
            } catch (NegativeException e) {
              System.out.println("Negative Coordinates for " + m.group(1));
            } catch (Exception e) {
              System.out.println("No such Aircraft: " + m.group(1));
            }
          }
          else
              System.out.println("Invalid input L" + i);

          i += 1;
        }

        while (count != 0) {
          wt.changeWeather();
          count -= 1;
        }
      }
      else {
        System.out.println("Usage: Simulator scenario_file");
      }
    } catch (NumberFormatException e) {
      System.out.println("The first line should be a positive number");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
