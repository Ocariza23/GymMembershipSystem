package Activity11;

public class i_Venus extends InnerPlanet {

          String surface;
          String oxygen;

        
          public i_Venus() {
                    name = "Venus"; 
                    planetType = "Inner Planet";
                   
                    surface = "Covered in thick clouds of sulfuric acid, with an extremely hot surface";
                    oxygen = "No breathable oxygen; mainly carbon dioxide";
          }

       
          public void displaySurface() {
                    System.out.println( "Surface: " + surface );
          }
       
          public void displayOxygen() {
                    System.out.println( "Oxygen: " + oxygen );
          }
}
