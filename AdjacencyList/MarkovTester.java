import java.util.ArrayList;

public class MarkovTester {
    public static void main(String[] args) {
        MarkovPrediction markov = new MarkovPrediction();
        markov.readData("./weather.csv");
        int num = 10000;
        String current = "Sunny";
        ArrayList<String> C = new ArrayList<>();
        ArrayList<String> PC = new ArrayList<>();
        ArrayList<String> T = new ArrayList<>();
        ArrayList<String> SN = new ArrayList<>();
        ArrayList<String> SU = new ArrayList<>();
        ArrayList<String> F = new ArrayList<>();
        ArrayList<String> R = new ArrayList<>();
        for (int index = 0; index < num; index++) {
            String next = markov.predictNextState(current);
            System.out.println(next);
            if (next.equals("Cloudy")) C.add(next);
            if (next.equals("Partly Cloudy")) PC.add(next);
            if (next.equals("Thunderstorm")) T.add(next);
            if (next.equals("Snowy")) SN.add(next);
            if (next.equals("Sunny")) SU.add(next);
            if (next.equals("Foggy")) F.add(next);
            if (next.equals("Rainy")) R.add(next);
        }
        System.out.print("From " + current + ": ");
        System.out.print("Cloudy-" + (double) C.size()/num*100 + " ");
        System.out.print("PartlyCloudy-" + (double) PC.size()/num*100 + " ");
        System.out.print("Thunder-" + (double) T.size()/num*100 + " ");
        System.out.print("Snowy-" + (double) SN.size()/num*100 + " ");
        System.out.print("Sunny-" + (double) SU.size()/num*100 + " ");
        System.out.print("Foggy-" + (double) F.size()/num*100 + " ");
        System.out.println("Rainy-" + (double) R.size()/num*100 + " ");
    }

}
