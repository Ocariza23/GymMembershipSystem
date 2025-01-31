package Activity11;

public class i_Mercury extends InnerPlanet {

          String temperature;
          String atmosphere;

          public i_Mercury() {
                    name = "Mercury";
                    planetType = "Inner Planet";

                    temperature = "Extremely high (up to 430°C) during the day and extremely cold (-180°C) at night";
                    atmosphere = "Very thin atmosphere; almost no atmosphere";
          }

          public void displayTemperature() {
                    System.out.println( "Temperature: " + temperature );
          }

          public void displayAtmosphere() {
                    System.out.println( "Atmosphere: " + atmosphere );
          }
}
