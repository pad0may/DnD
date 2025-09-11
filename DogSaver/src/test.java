import java.util.ArrayList;

public class test {
  public static void main(String[] args) {
    MyArrayList list = new MyArrayList<>(5);
    // String str = "1";
    // for (int i = 0; i < 100000000; i++) {
    // list.add(str);
    // }
    String one = "1";
    String two = "2";
    String three = "3";
    String four = "4";
    String five = "5";
    String six = "6";
    list.add(one);
    list.add(two);
    list.add(three);
    list.add(five);
    list.add(six);
    System.out.println(list.toString());
    list.add(3, four);
    System.out.println(list.toString());
  }
}
