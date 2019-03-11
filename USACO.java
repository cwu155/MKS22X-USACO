import java.util.*;
import java.io.*;

public class USACO{

  public static int[][] map;
  public static int r, c, e, n, rows, cols;
  public static String line;

  public static int[] stringToInt(String input){
    String[] stringArray = input.split(" ");
    int[] result = new int[stringArray.length];

      for (int i = 0; i < stringArray.length; i++){
        result[i] = Integer.parseInt(stringArray[i]);
      }
    return result;
  }

  public static void readFile(String filename) throws FileNotFoundException, IOException{
    try {
      File text = new File(filename);
      Scanner inf = new Scanner(text);

      BufferedReader brTest = new BufferedReader(new FileReader(filename));
      String firstLine = brTest.readLine();
      String[] firstLineArray = new String[4];
      firstLineArray = firstLine.split(" ");
      r = Integer.parseInt(firstLineArray[0]);
      c = Integer.parseInt(firstLineArray[1]);
      e = Integer.parseInt(firstLineArray[2]);
      n = Integer.parseInt(firstLineArray[3]);

      map = new int[r][c];

      inf.nextLine();
      for (int i = 0; i < r; i ++) {
        for (int j = 0; j < c; j++) {
          map[i][j] = inf.nextInt();
        }
      }

      // File text1 = new File(filename);
      // Scanner inf1 = new Scanner(text1);
      //
      // inf1.nextLine();
      //    while(inf1.hasNextLine()){
      //      String next = inf1.nextLine();
      //      map[r] = stringToInt(next);
      //      if (map[r].length == 3){;}
      //      r += 1;
      //    }

      } catch (FileNotFoundException ex){
        System.out.println("Yikes");
      } catch (IOException ex){
        System.out.println("Yikes");
      }
  }

    //Debug purposes
    public static String toString(int[][] map){
      String result = "";
      for (int i = 0; i < map.length; i++){
          for (int j = 0; j < map[i].length; j++){

            if (j == map[i].length - 1){
              result += map[i][j] + "\n";
              } else {
              result += map[i][j] + " ";
              }
            }
          }
        return result;
      }


    public static void main(String[] args)throws FileNotFoundException, IOException{
      readFile("makelake.in");
      System.out.println(toString(map));
    }
  }
