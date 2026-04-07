import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;


public class MiniGPT {

	public HashMap<String, ArrayList<Character>> chain = new HashMap<String, ArrayList<Character>>();
	public ArrayList<String> keys = new ArrayList<String>();
	public int chainOrders;

	public MiniGPT(String fileName, int chainOrder) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int charAsInt;
			ArrayList<Character> keyVal = new ArrayList<Character>();
            // Read until the end of the stream (-1 is returned)
            while ((charAsInt = reader.read()) != -1) {
                // Cast the integer value to a character
                char character = (char) charAsInt;
				chainOrders = chainOrder;
                if (keyVal.size() == chainOrder+1) {
					String keyValString = keyVal.toString().replaceAll(", ", "");
					String key = keyValString.substring(1, chainOrder+1);
					char val = keyVal.get(chainOrder);
					// System.out.println("" + keyValString + key + " | " + val);

					if (chain.containsKey(key)) {
						chain.get(key).add(val);
                	} else if (!chain.containsKey(key)) {
						ArrayList<Character> addArray = new ArrayList<>();
						addArray.add(val);
						chain.put(key, addArray);
						keys.add(key);
                	}

					keyVal.remove(0);
					keyVal.add(character);
				} else {
					keyVal.add(character);
				}
            }
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
	}

	
	public void generateText(String outputFileName, int numChars) {
		StringBuilder output = new StringBuilder();
		output.append(keys.get((int) Math.floor(Math.random()*(keys.size()))));
		for (int i = output.length(); i < numChars; i++) {
			String prev = output.substring(i-(chainOrders), i);
			int random = (int) Math.floor(Math.random()*(chain.get(prev).size()));
			output.append(chain.get(prev).get(random));
		}

        try {
            BufferedWriter file = new BufferedWriter(new FileWriter(outputFileName));
			file.write(output.toString());
			file.close();
        } catch (IOException e) {
			System.err.println("An I/O error occurred: " + e.getMessage());
        }
	}
}
