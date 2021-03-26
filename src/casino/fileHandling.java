package casino;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class fileHandling {

    public static String folderDirectory = System.getProperty("user.dir") + "\\userList.txt";

    public static void writeFile(ArrayList<Person> userInfo) {

        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < userInfo.size(); i++) {
                printToFile.println(userInfo.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public static ArrayList<Person> readFile() {
        ArrayList<Person> userInfo = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] userDetails = lineFromFile.split(", ");
                Person a = new Person(userDetails[0], userDetails[1], userDetails[2], Integer.parseInt(userDetails[3]), Integer.parseInt(userDetails[4]));
                userInfo.add(a);
            }
            read.close();
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return userInfo;
    }
}
