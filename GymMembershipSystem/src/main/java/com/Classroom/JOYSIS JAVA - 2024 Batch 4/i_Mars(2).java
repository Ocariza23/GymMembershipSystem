package Activity11;

public class i_Mars extends InnerPlanet {

          String surface;
          String atmosphere;

          public i_Mars() {
                    name = "Mars";
                    planetType = "Inner Planet";

                    surface = "Red surface with iron oxide (rust), features large volcanoes and valleys";
                    atmosphere = "Thin atmosphere composed mostly of carbon dioxide, very little oxygen";
          }

          public void displaySurface() {
                    System.out.println( "Surface: " + surface );
          }

          public void displayAtmosphere() {
                    System.out.println( "Atmosphere: " + atmosphere );
          }
}
