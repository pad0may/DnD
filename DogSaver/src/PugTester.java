import java.util.ArrayList;

public class PugTester {
  public static void main(String[] args) {
    ArrayList<Dog> list = new ArrayList<>();
    Dog dog1 = new Dog("dog1", "golden a");
    Dog dog2 = new Dog("dog2", "not a");
    Dog dog3 = new Dog("dog3", "gon a");

    Dog dog4 = new Dog("dog4", "golden a");
    Dog dog5 = new Dog("dog5", "glden a");
    Dog dog6 = new Dog("dog6", "goen a");

    Dog dog7 = new Dog("dog7", "golden a");
    Dog dog8 = new Dog("dog8", "golden a");
    Dog dog9 = new Dog("dog9", "golden a");

    list.add(dog1);
    list.add(dog2);
    list.add(dog3);
    list.add(dog4);
    list.add(dog5);
    list.add(dog6);
    list.add(dog7);
    list.add(dog8);
    list.add(dog9);

    PugSaver.rescuePugs(list);

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i).getBreed() + " | " + list.get(i).getName());
    }
  }
}
