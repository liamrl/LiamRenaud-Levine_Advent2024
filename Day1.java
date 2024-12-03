import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");

        int total = 0;

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();


        for (String s : fileData){
            String[] splitSample = s.split("   ");

            list1.add(Integer.parseInt(splitSample[0]));
            list2.add(Integer.parseInt(splitSample[1]));

        }

        Collections.sort(list1);
        System.out.println(list1);
        Collections.sort(list2);
        System.out.println(list2);

        for (int i = 0; i < list1.size(); i++){
            total += Math.abs(list1.get(i) - list2.get(i));

        }

        System.out.println(total);


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
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }


}