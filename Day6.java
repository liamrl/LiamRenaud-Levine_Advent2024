import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day6 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day3Input.txt");

        int row = fileData.size();
        int column = fileData.get(0).length();

        String[][] map = new String[row][col];
        
        for (int i = 0; i < fileData.size(); i++){
            for (int j = 0; j < fileData.get(0).length(); j++){
                map[i][j] = fileData.get(i).indexOf(j);
            }
        }

        for (String[] str : map){
            for (String s : str){
                System.out.print(s);
            }
            System.out.println();
        }

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
