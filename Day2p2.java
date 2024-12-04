import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Day2p2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");

        int total = 0;
        for (String s : fileData){
            String[] spl = s.split(" ");

            if ((isDecreasing(spl) || isIncreasing(spl)) && difference(spl)){
                total++;
            }

        }
        System.out.println(total);

    }

    public static boolean isIncreasing(String[] list){
        int count = 0;
        for (int i = 1; i < list.length - 1; i++){
            if (Integer.parseInt(list[i - 1]) >= Integer.parseInt(list[i])){
                count++;
                if (!(count < 2 && Integer.parseInt(list[i - 1]) >= Integer.parseInt(list[i + 1]))){
                    return false;
                }

            }
        }
        return true;
    }

    public static boolean isDecreasing(String[] list){
        int count = 0;
        for (int i = 1; i < list.length - 1; i++){
            if (Integer.parseInt(list[i]) >= Integer.parseInt(list[i - 1])){
                count++;
                if (!(count < 2 && Integer.parseInt(list[i - 1]) >= Integer.parseInt(list[i + 1]))){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean difference(String[] list){
        for (int i = 1; i < list.length; i++){
            if (Math.abs(Integer.parseInt(list[i]) - Integer.parseInt(list[i - 1])) > 3 || Math.abs(Integer.parseInt(list[i]) - Integer.parseInt(list[i - 1])) < 1){

            }
        }
        return true;
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