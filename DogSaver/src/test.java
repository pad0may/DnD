import java.util.ArrayList;

public class test {
  public static void main(String[] args) {
    MyArrayList list = new MyArrayList<>();
    String str = "1";
    for (int i = 0; i < 99; i++) {
      list.add(str);
    }
    System.out.println(list.toString());
  }
}
