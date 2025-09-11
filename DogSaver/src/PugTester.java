import java.util.ArrayList;

public class PugTester {
  public static void main(String[] args) {
    MyArrayList<Dog> list = new MyArrayList<>();
    Dog dog1 = new Dog("dog1", "golden a");
    Dog dog2 = new Dog("dog2", "not a");
    Dog dog3 = new Dog("dog3", "gon a");

    Dog dog4 = new Dog("dog4", "golden a");
    Dog dog5 = new Dog("dog5", "glden a");
    Dog dog6 = new Dog("dog6", "goen a");

    Dog dog7 = new Dog("dog7", "golden a");
    Dog dog8 = new Dog("dog8", "golden a");
    Dog dog9 = new Dog("dog9", "golden a");

    long timeStart = System.nanoTime();

    for (int i = 0; i < 1000000000 / 2; i++) {
      list.add(dog1);
      list.add(dog2);
      // list.add(dog3);
      // list.add(dog4);
      // list.add(dog5);
      // list.add(dog6);
      // list.add(dog7);
      // list.add(dog8);
      // list.add(dog9);
    }

    list.set(741, dog1);
    list.set(421, dog1);
    list.set(372, dog1);
    list.set(23, dog1);
    list.set(1, dog1);
    System.out.println("Initialization time: " + (System.nanoTime() - timeStart) / 1000000);
    System.out.println("begin sort");

    timeStart = System.nanoTime();

    PugSaver.rescuePugs(list);

    System.out.println("Final time: " + ((System.nanoTime() - timeStart) / 1000000));

    for (int i = 0; i < 5; i++) {
      System.out.println(list.get(list.size() - i - 1).getBreed());
    }

    // for (int i = 0; i < list.size(); i++) {
    // System.out.println(list.get(i).getBreed() + " | " + list.get(i).getName());
    // }
  }
}
