package Activity11;

public class Moon {

          String crater;
          String size;

          public Moon() {
                    crater = "Has a large number of craters";
                    size = "Its diameter is about 3,474 km";
          }

          public void displayCrater() {
                    System.out.println( "Crater: " + crater );
          }

          public void displaySize() {
                    System.out.println( "Size: " + size );
          }
}
