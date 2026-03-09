import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MarkovPrediction {

    // Please define your own variables and data structures
    // 
    public HashMap<String, ArrayList<String>> chain = new HashMap<String, ArrayList<String>>();
    public ArrayList<String> keys = new ArrayList<String>();

    public ArrayList<String[]> readData(String filePath) {  
        ArrayList<String[]> ret = new ArrayList<>();  
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split(",");
                ret.add(str);
                if (chain.containsKey(str[0])) {
                    chain.get(str[0]).add(str[1]);
                } else if (!chain.containsKey(str[0])) {
                    ArrayList<String> addArray = new ArrayList<>();
                    addArray.add(str[1]);
                    chain.put(str[0], addArray);
                    keys.add(str[0]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    // Method to predict the next state given a current state
    public String predictNextState(String currentState) {
        ArrayList<String> states = chain.get(currentState);
        int random = (int) Math.floor(Math.random()*(states.size()));
        return states.get(random);
    }

}