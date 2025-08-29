import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

  private static int dogCount = 0;
  private static Dog tempDog;

  // Moves every dog whose breed is "Pug" in the list to the back of the list
  public static void rescuePugs(ArrayList<Dog> list) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getBreed().contains("golden")) {
        System.out.println(list.get(i));
        for (int x = list.size() - 1; x >= i; x--) {
          if (!list.get(x).getBreed().contains("golden")) {
            tempDog = list.get(x);
            list.set(x, list.get(i));
            list.set(i, tempDog);
            if (x == list.size() && list.get(x).getBreed().substring(0, 5).equals("golden")) {
              break;
            }
          }
        }
      }
    }
  }
}
