package Activity11;

public class Main {

          public static void main( String[] args ) {

                    i_Mercury mercury = new i_Mercury();
                    i_Venus venus = new i_Venus();
                    i_Earth earth = new i_Earth();
                    i_Mars mars = new i_Mars();

                    o_Jupiter jupiter = new o_Jupiter();
                    o_Saturn saturn = new o_Saturn();
                    o_Uranus uranus = new o_Uranus();
                    o_Neptune neptune = new o_Neptune();

                    System.out.println( "=====================" );
                    System.out.println( "=== Inner Planets ===" );
                    System.out.println( "=====================\n" );

                    System.out.println( "***************" );
                    System.out.println( "*** Mercury ***" );
                    System.out.println( "***************" );
                    mercury.displayPlanetName();
                    mercury.displayPlanetType();
                    mercury.displayTemperature();
                    mercury.displayAtmosphere();
                    System.out.println();

                    System.out.println( "*************" );
                    System.out.println( "*** Venus ***" );
                    System.out.println( "*************" );
                    venus.displayPlanetName();
                    venus.displayPlanetType();
                    venus.displaySurface();
                    venus.displayOxygen();
                    System.out.println();

                    System.out.println( "*************" );
                    System.out.println( "*** Earth ***" );
                    System.out.println( "*************" );
                    earth.displayPlanetName();
                    earth.displayPlanetType();
                    earth.displayOxygen();
                    earth.displayWater();
                    earth.displayMoonProperties();
                    System.out.println();

                    System.out.println( "************" );
                    System.out.println( "*** Mars ***" );
                    System.out.println( "************" );
                    mars.displayPlanetName();
                    mars.displayPlanetType();
                    mars.displaySurface();
                    mars.displayAtmosphere();
                    System.out.println();

                    System.out.println( "=====================" );
                    System.out.println( "=== Outer Planets ===" );
                    System.out.println( "=====================\n" );

                    System.out.println( "***************" );
                    System.out.println( "*** Jupiter ***" );
                    System.out.println( "***************" );
                    jupiter.displayPlanetName();
                    jupiter.displayPlanetType();
                    jupiter.displayRings();
                    jupiter.displayStorms();
                    System.out.println();

                    System.out.println( "**************" );
                    System.out.println( "*** Saturn ***" );
                    System.out.println( "**************" );
                    saturn.displayPlanetName();
                    saturn.displayPlanetType();
                    saturn.displayRings();
                    saturn.displayMoons();
                    System.out.println();

                    System.out.println( "**************" );
                    System.out.println( "*** Uranus ***" );
                    System.out.println( "**************" );
                    uranus.displayPlanetName();
                    uranus.displayPlanetType();
                    uranus.displayTiltedAxis();
                    uranus.displayRings();
                    System.out.println();

                    System.out.println( "***************" );
                    System.out.println( "*** Neptune ***" );
                    System.out.println( "***************" );
                    neptune.displayPlanetName();
                    neptune.displayPlanetType();
                    neptune.displayWinds();
                    neptune.displayColor();
          }
}
