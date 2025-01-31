package Activity11;

public class o_Neptune extends OuterPlanet {

          String winds;
          String color;

          public o_Neptune() {
                    name = "Neptune";
                    planetType = "Outer Planet";

                    winds = "Strongest winds in the solar system, reaching speeds of over 2,000 km/h.";
                    color = "Blue color due to methane in its atmosphere.";
          }

          public void displayWinds() {
                    System.out.println( "Winds: " + winds );
          }

          public void displayColor() {
                    System.out.println( "Color: " + color );
          }
}
