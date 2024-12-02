import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");

        int total = 0;

        for (String s : fileData){
            String[] splitSample = s.split("   ");

            int[] listOneStr = strToArray(splitSample[0]);

            int[] listTwoStr = strToArray(splitSample[1]);


            for (int i = 0; i < 5; i++){
                total += Math.abs(listOneStr[i] - listTwoStr[i]);
            }


        }



    }

    public static int[] strToArray(String list){
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++){
            arr[i] = parseInt(list.substring(i, i+1));
        }

        Arrays.sort(arr);
        return arr;
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