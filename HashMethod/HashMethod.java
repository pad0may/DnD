public class HashMethod {
    public static int HashValue(String str) {
        str = str.toLowerCase().replace(" ", "");
        str = str.replace("'", str);
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            ret += Math.abs(str.charAt(i) - 'a') * (i+1);
        }
        return ret % 501;
    }

    public static void main(String[] args) {
        String[] hashArray = new String[501];
        String[] names = {
        "Mateo Atluri",
        "Asher Butan",
        "Xander Cheuk",
        "Taj Clement",
        "Camille Condren",
        "Evan Daneshrad",
        "Felicia Duan",
        "Jake Effress",
        "Zachary Figlin",
        "James Graczyk",
        "David Hadi",
        "Quinn Harris",
        "Jackson Hubbard",
        "Siona Kirschner",
        "Dylan Martin",
        "Morgan Maynard",
        "Yari Milakin",
        "Waller Morton",
        "Andrew Stout",
        "Mattin Tasbihgoo",
        "Andrew Theiss",
        "Carter Tsao",
        "Rose Ananda",
        "Autrin Anousheh",
        "Joshua Bie",
        "Elsa Cheng",
        "Isabel Erlic",
        "Jojo Gott",
        "Connor Jun",
        "Jordan Kay",
        "James Klarin",
        "Judy Law",
        "Grayden Lichtman",
        "Runshi Liu",
        "Juan Lopez",
        "Henry Margolis",
        "Garret Morberg-Nguyen",
        "Kai Nantamanasikarn",
        "Remi O'Dell",
        "Emil Palmer",
        "Jaden Park",
        "Ryder Rufi",
        "Alice Shao",
        "Marco Silvera",
        "Samuel Tabib",
        "Andrew Theiss",
        "Shriya Vishwas",
        "Nick Waller",
        "Vikram Wright",
        "Alex Yang",
        "Ethan You",
        "Lucas Yu",
        "Jack Yuan",
        "Jayden Zepeda",
        "Lawrence Zhao",
        "Michael Zhao",
        "Olivia Zhu"
        };

        for (String name : names) {
            hashArray[HashValue(name)] = name;
        }

        int x = 0;
        for (int i = 0; i < hashArray.length; i++) {
            if (hashArray[i] != null) {
                System.out.println(hashArray[i]);
                x++;
            }
        }
        System.out.println(57-x);
    }
}