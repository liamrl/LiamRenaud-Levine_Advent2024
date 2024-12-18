import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Day6 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day6Input.txt");

        int row = fileData.size();
        int column = fileData.get(0).length();

        String[][] map = new String[row][column];

        int posX = 0;
        int posY = 0;

        final int LASTY = fileData.size() - 1;
        final int LASTX = fileData.get(0).length() - 1;

        for (int i = 0; i < fileData.size(); i++){
            for (int j = 0; j < fileData.get(0).length(); j++){
                if (fileData.get(i).substring(j, j + 1).equals("^")){
                    posX = j;
                    posY = i;
                }
                map[i][j] = fileData.get(i).substring(j, j + 1);
            }
        }

        ArrayList<ArrayList<Integer>> positions = new ArrayList<>();

        boolean up = true;
        boolean right = false;
        boolean down = false;
        boolean left = false;


        while (true){
            if (up){
                if (posY == 0){
                    map[posY][posX] = "X";
                    break;
                } else if (map[posY - 1][posX].equals("#")){
                    up = false;
                    right = true;
                } else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(posY);
                    temp.add(posX);
                    temp.add(0);
                    positions.add(temp);

                    map[posY][posX] = "X";
                    posY--;
                }

            }

            if (right){
                if (posX == LASTX){
                    map[posY][posX] = "X";
                    break;
                } else if (map[posY][posX + 1].equals("#")){
                    right = false;
                    down = true;
                } else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(posY);
                    temp.add(posX);
                    temp.add(1);
                    positions.add(temp);

                    map[posY][posX] = "X";
                    posX++;
                }
            }

            if (down){
                if (posY == LASTY){
                    map[posY][posX] = "X";
                    break;
                } else if (map[posY + 1][posX].equals("#")){
                    down = false;
                    left = true;
                } else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(posY);
                    temp.add(posX);
                    temp.add(2);
                    positions.add(temp);

                    map[posY][posX] = "X";
                    posY++;
                }

            }

            if (left){
                if (posX == 0){
                    map[posY][posX] = "X";
                    break;
                } else if (map[posY][posX - 1].equals("#")){
                    left = false;
                    up = true;
                } else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(posY);
                    temp.add(posX);
                    temp.add(3);
                    positions.add(temp);
                    map[posY][posX] = "X";
                    posX--;
                }
            }

        }

        int total = 0;



        for (String[] str : map){
            for (String s : str){
                if (s.equals("X")){
                    total++;
                }
            }
        }

        System.out.println(total);




        System.out.println(positions.size());




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