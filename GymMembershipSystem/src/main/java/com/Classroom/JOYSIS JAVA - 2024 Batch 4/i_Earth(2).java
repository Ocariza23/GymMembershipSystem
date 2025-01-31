package Activity11;

public class i_Earth extends InnerPlanet {

          String oxygen;
          String water;

          Moon earthMoon;

          public i_Earth() {
                    name = "Earth";
                    planetType = "Inner Planet";

                    oxygen = "Has a breathable atmosphere with oxygen";
                    water = "Surface covered by oceans and lakes, with abundant liquid water";

                    earthMoon = new Moon();
          }

          public void displayOxygen() {
                    System.out.println( "Oxygen: " + oxygen );
          }

          public void displayWater() {
                    System.out.println( "Water: " + water );
          }

          public void displayMoonProperties() {
                    System.out.println( "\nEarth's Moon:" );
                    earthMoon.displayCrater();
                    earthMoon.displaySize();

          }
}
