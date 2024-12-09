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

            ArrayList<Integer> list = new ArrayList<>();
            for (String st : spl){
                list.add(Integer.parseInt(st));
            }

            if ((isDecreasing(list) || difference(list)) && difference(list)){
                total++;
            }

        }
        System.out.println(total);

    }

    public static boolean isIncreasing(ArrayList<Integer> list){
        int count = 0;
        for (int i = 1; i < list.size(); i++){
            if (list.get(i - 1) >= list.get(i)){
                if (!removeOne(list)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isDecreasing(ArrayList<Integer> list){
        int count = 0;
        for (int i = 1; i < list.size(); i++){
            if (list.get(i - 1) <= list.get(i)){
                if (!removeOne(list)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean difference(ArrayList<Integer> list){
        int count = 0;
        for (int i = 1; i < list.size(); i++){
            if (Math.abs(list.get(i - 1) - list.get(i)) > 3 || Math.abs(list.get(i) - list.get(i - 1)) < 1) {
                if (!removeOne(list)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean removeOne(ArrayList<Integer> list){
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.size(); j++){
                if (!(j == i)){
                    list2.add(list.get(j));
                }

            }
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
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }


}