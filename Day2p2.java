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

            System.out.println(list);

            if ((isDecreasing(list, true) || isIncreasing(list, true)) && difference(list, true)){
                System.out.println(true);
                total++;
            }

        }
        System.out.println(total);

    }

    public static boolean isIncreasing(ArrayList<Integer> list, boolean q){
        for (int i = 1; i < list.size(); i++){
            if (list.get(i - 1) >= list.get(i) && q){
                q = false;
                if (!removeOne(list)){
                    return false;
                }  else if (removeOne(list)) {
                    return true;
                }

            }
            else if (list.get(i - 1) >= list.get(i) && !q){
                return false;
            }
        }
        return true;
    }

    public static boolean isDecreasing(ArrayList<Integer> list, boolean q){
        for (int i = 1; i < list.size(); i++){
            if (list.get(i - 1) <= list.get(i) && q){
                q = false;
                if (!removeOne(list)){
                    return false;
                } else if (removeOne(list)){
                    return true;
                }
            } else if (list.get(i - 1) <= list.get(i) && !q){
                return false;
            }
        }
        return true;
    }

    public static boolean difference(ArrayList<Integer> list, boolean q){
        for (int i = 1; i < list.size(); i++){
            if ((Math.abs(list.get(i - 1) - list.get(i)) > 3 || Math.abs(list.get(i) - list.get(i - 1)) < 1) && q) {
                q = false;
                if (!removeOne(list)){
                    return false;
                } else if (removeOne(list)){
                    return true;
                }
            } else if ((Math.abs(list.get(i - 1) - list.get(i)) > 3 || Math.abs(list.get(i) - list.get(i - 1)) < 1) && !q){
                return false;
            }
        }
        return true;
    }

    public static boolean removeOne(ArrayList<Integer> list){
        System.out.println(list);
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            for (int j : list){
                    list2.add(j);
            }
            list2.remove(i);
            // System.out.println(list2);
            if ((isIncreasing(list2, false) || isDecreasing(list2, false)) && difference(list2, false)){
                System.out.println(list2);
                return true;
            }
            list2.clear();
        }
        return false;
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