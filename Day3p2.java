import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3p2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day3Input.txt");



        Pattern pattern = Pattern.compile("mul\\([0-9]{1,3},[0-9]{1,3}\\)");

        int total = 0;
        ArrayList<String> oD = onlyDo(fileData);
        for (int i = 0; i < oD.size(); i++){
            String longString = oD.get(i);
            Matcher matcher = pattern.matcher(longString);


            while (matcher.find()){
                int firstNum = matcher.start() + 4;
                int lastNum = matcher.end() - 1;
                String nums = longString.substring(firstNum, lastNum);
                String[] split = nums.split(",");

                total += (Integer.parseInt(split[0]) * Integer.parseInt(split[1]));
            }
        }


        System.out.println(total);

    }


    public static ArrayList<String> onlyDo (ArrayList<String> list){

        ArrayList<String> onlyDo = new ArrayList<>();
        Pattern p = Pattern.compile("don't\\(\\)|do\\(\\)");
        ArrayList<Integer> indexDo = new ArrayList<>();
        indexDo.add(0);
        boolean boo = true;

        for (int i = 0; i < list.size(); i++){
            String longString = list.get(i);

            Matcher m = p.matcher(longString);

            while(m.find()){
                if ((m.end() - m.start() == 7) && boo){
                    indexDo.add(m.start());
                    boo = false;
                } else if ((m.end() - m.start() == 4) && !boo){
                    indexDo.add(m.start());
                    boo = true;
                }
            }

            if (boo){
                indexDo.add(longString.length() - 1);
            }

            System.out.println(indexDo);
            System.out.println(longString.length());


            for (int j = 0; j < list.size(); j++){
                for (int k = 0; k < indexDo.size() - 1; k+=2){
                    onlyDo.add(longString.substring(indexDo.get(k), indexDo.get(k + 1)));
                }
            }


            indexDo.clear();

            if (boo){
                indexDo.add(0);
            }

        }
        System.out.println(onlyDo);

        return onlyDo;
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