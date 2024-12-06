import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day3 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day3Input.txt");


        Pattern pattern = Pattern.compile("mul\\([0-9]{1,3},[0-9]{1,3}\\)");

        int count = 0;
        for (int i = 0; i < fileData.size(); i++){
            Matcher matcher = pattern.matcher(fileData.get(i));

            while (matcher.find()){
                count++;
            }
        }

        System.out.println(count);

    }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
