import java.util.*;
import java.io.*;

public class USACO{

  public static int[][] map;
  public static int[][] cowGrid;
  public static int[][] instructions;
  public static int r, c, e, n, R_s, C_s;
  public static String line;

  //Helper method for reading file.
  public static int[] stringToInt(String input){
    String[] stringArray = input.split(" ");
    int[] result = new int[stringArray.length];

      for (int i = 0; i < stringArray.length; i++){
        result[i] = Integer.parseInt(stringArray[i]);
      }
    return result;
  }

  //Reads file, assigns variables.
  public static void readFile(String filename) throws FileNotFoundException, IOException{
    try {
      //Scanners and readers and everything??
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      BufferedReader brTest = new BufferedReader(new FileReader(filename));
      String firstLine = brTest.readLine();
      String[] firstLineArray = new String[4];
      firstLineArray = firstLine.split(" ");

      //Determines rows, cols, elevation, number of instructions.
      r = Integer.parseInt(firstLineArray[0]);
      c = Integer.parseInt(firstLineArray[1]);
      e = Integer.parseInt(firstLineArray[2]);
      n = Integer.parseInt(firstLineArray[3]);

      //Initializes map.
      map = new int[r][c];
      inf.nextLine();
      for (int i = 0; i < r; i ++){
        for (int j = 0; j < c; j++) {
          map[i][j] = inf.nextInt();
        }
      }
      //System.out.println(inf.nextLine());
      //System.out.println(inf.nextLine());

      //Instructions.

      instructions = new int[n][3];
      for (int i = 0; i < n; i++){
        inf.nextLine();
        for (int j = 0; j < 3; j++){
        instructions[i][j] = inf.nextInt();
      }
    }
      //Exceptions.
      } catch (FileNotFoundException ex){
        System.out.println("Yikes");
      } catch (IOException ex){
        System.out.println("Yikes");
      }
  }

    //Debug purposes.
    public static String toString(int[][] grid){
      String result = "";
      for (int i = 0; i < grid.length; i++){
          for (int j = 0; j < grid[i].length; j++){

            if (j == grid[i].length - 1){
              result += grid[i][j] + "\n";
              } else {
              result += grid[i][j] + " ";
              }
            }
          }
        return result;
      }

    //Initializes 3x3 cow grid.
    public static void initCowGrid(int Rs, int Cs){
      cowGrid = new int[3][3];
    }

    public static void main(String[] args)throws FileNotFoundException, IOException{
      readFile("makelake.in");
      System.out.println(toString(map));
      System.out.println(toString(instructions));
    }
  }
