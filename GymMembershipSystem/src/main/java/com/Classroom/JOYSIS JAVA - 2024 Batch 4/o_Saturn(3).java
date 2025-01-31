package Activity11;

public class o_Saturn extends OuterPlanet {

          String rings;
          String moons;

          public o_Saturn() {
                    name = "Saturn";
                    planetType = "Outer Planet";

                    rings = "Prominent and beautiful ring system made of ice and rock";
                    moons = "Has numerous moons, including Titan, the second-largest moon in the solar system";
          }

          public void displayRings() {
                    System.out.println( "Rings: " + rings );
          }

          public void displayMoons() {
                    System.out.println( "Moons: " + moons );
          }
}
