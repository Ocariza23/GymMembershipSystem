package Activity11;

public class o_Uranus extends OuterPlanet {

          String tiltedAxis;
          String rings;

          public o_Uranus() {
                    name = "Uranus";
                    planetType = "Outer Planet";

                    tiltedAxis = "It has a unique tilt, rotating on its side compared to other planets.";
                    rings = "Has a faint ring system, which is less prominent than Saturn's.";
          }

          public void displayTiltedAxis() {
                    System.out.println( "Tilted Axis: " + tiltedAxis );
          }

          public void displayRings() {
                    System.out.println( "Rings: " + rings );
          }
}
