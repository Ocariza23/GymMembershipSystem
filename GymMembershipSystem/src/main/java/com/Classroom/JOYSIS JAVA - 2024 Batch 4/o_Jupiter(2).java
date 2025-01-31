package Activity11;

public class o_Jupiter extends OuterPlanet {

          String rings;
          String storms;

          public o_Jupiter() {
                    name = "Jupiter";
                    planetType = "Outer Planet";

                    rings = "Has faint rings made of dust particles and ice";
                    storms = "Known for the Great Red Spot, a massive storm that has lasted for centuries";
          }

          public void displayRings() {
                    System.out.println( "Rings: " + rings );
          }

          public void displayStorms() {
                    System.out.println( "Storms: " + storms );
          }
}
