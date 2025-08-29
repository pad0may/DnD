import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

  private static int dogCount = 0;
  private static Dog tempDog;

  // Moves every dog whose breed is "Pug" in the list to the back of the list
  public static void rescuePugs(ArrayList<Dog> list) {
    for (int i = list.size(); i < list.size(); i++) {
      if (list.get(i).getBreed().substring(0, 5).equals("golden")) {
        for (int x = i; x < list.size() - i; x++) {
          if (!list.get(x).getBreed().substring(0, 5).equals("golden")) {
            tempDog = list.get(x);
            list.set(x, list.get(i));
            list.set(i, tempDog);
          }
        }
      }
      dogCount++;
      if (dogCount == list.size()) {
        break;
      }
    }
  }
}
