public class ChocolateHashMapTester {
    public static void main(String[] args) {
        ChocolateHashMap map = new ChocolateHashMap<>();
        System.out.println(map.put("1", "1value"));
        System.out.println(map.put("10", "value"));
        System.out.println(map.put("2", "2value"));
        System.out.println(map.put("3", "3value"));
        System.out.println(map.put("4", "4value"));
        System.out.println(map.put("5", "5value"));
        System.out.println(map.put("6", "6value"));
        System.out.println(map.put("7", "7value"));
        System.out.println(map.put("8", "8value"));
        System.out.println(map.put("9", "9value"));
        System.out.println(map.put("11", "11value"));
        System.out.println(map.put("12", "12value"));
        System.out.println(map.put("13", "13value"));
        System.out.println(map.put("14", "14value"));
        System.out.println(map.put("15", "15value"));
        System.out.println(map.put("16", "16value"));
        System.out.println(map.put("17", "17value"));
        System.out.println(map.put("18", "18value"));
        System.out.println(map.toString());
        System.out.println(map.containsKey("10"));
        System.out.println(map.containsValue("1 value"));
        System.out.println(map.containsValue("1value"));
        System.out.println(map.remove("1"));
        System.out.println(map.toString());
        map.rehash(10);
        System.out.println(map.get("2"));
        System.out.println(map.currentLoadFactor());
        map.put("null", null);
        System.out.println(map.containsValue(null));
        System.out.println(map.toString());
        map.remove("5");
        System.out.println(map.toString());

    }
}
