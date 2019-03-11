import java.util.*;
import java.io.*;

public class USACO{

  //Bronze variables!
  public static int[][] map, cowGrid, instructions;
  public static int r, c, e, n, R_s, C_s, max, aggregate;
  public static String line;

  //Silver variables!
  public static int[][] pasture, moveGrid;
  public static int N, M, T, R1, C1, R2, C2, count;

  //Helper method for reading files.
  public static int[] stringToInt(String original){
    String[] stringArray = original.split(" ");
    int[] result = new int[stringArray.length];

      for (int i = 0; i < stringArray.length; i++){
        result[i] = Integer.parseInt(stringArray[i]);
      }
    return result;
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

  //Reads Bronze file, assigns variables.
  public static void readFileBronze(String filename) throws FileNotFoundException, IOException{
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
      for (int i = 0; i < r; i++){
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

  //Initializes 3x3 cow grid, changes level of pasture after cow stomping.
  public static void changeLevel(int Rs, int Cs, int level, int[][] original){
    cowGrid = new int[3][3];
    max = 0;

    //Finds the max number in the 3x3 grid.
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (max < original[Rs + i][Cs + j]){
          max = original[Rs + i][Cs + j];
        }
      }
    }

    //Changes the depth of the grid.
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (max - original[Rs + i][Cs + j] <= level){
          original[Rs + i][Cs + j] = max - level;
        }
      }
    }
  }

  //Changes depth of pasture.
  public static void changeDepth(int e, int[][] original){
    for (int i = 0; i < original.length; i++){
      for (int j = 0; j < original[0].length; j++){
        if (original[i][j] > e){
          original[i][j] = 0;
        } else {
          original[i][j] = e - original[i][j];
        }
      }
    }
  }

  //Calculates final volume.
  public static int findVol(int[][] original){
    aggregate = 0;
    for (int i = 0; i < original.length; i++){
      for (int j = 0; j < original[0].length; j++){
        aggregate += original[i][j];
      }
    }
    return (aggregate * 72 * 72);
  }

  //Full bronze method.
  public static int bronze(String filename) throws FileNotFoundException, IOException{
    readFileBronze(filename);

    for (int i = 0; i < instructions.length; i++){
      R_s = instructions[i][0];
      C_s = instructions[i][1];
      changeLevel(R_s - 1, C_s - 1, instructions[i][2], map);
    }

    changeDepth(e, map);

    return findVol(map);
  }

  //Reads Silver file, assigns variables.
  public static void readFileSilver(String filename) throws FileNotFoundException, IOException{
    try {
      //Scanners and readers and everything??
      File text = new File(filename);
      Scanner inf = new Scanner(text);
      BufferedReader brTest = new BufferedReader(new FileReader(filename));
      String firstLine = brTest.readLine();
      String[] firstLineArray = new String[3];
      firstLineArray = firstLine.split(" ");

      //Determines number of rows, cows, and time.
      N = Integer.parseInt(firstLineArray[0]);
      M = Integer.parseInt(firstLineArray[1]);
      T = Integer.parseInt(firstLineArray[2]);

      //Initializes pasture. Assume 0 for empty space, -1 for a tree.
      String temp = "";
      pasture = new int[N][M];
      inf.nextLine();

      for (int i = 0; i < N; i++){
        temp = inf.next();

        for (int j = 0; j < M; j++){
          if (temp.charAt(j) == '.'){
              pasture[i][j] = 0;
          }
          if (temp.charAt(j) == '*'){
              pasture[i][j] = -1;
          }
        }
      }

      //Determines (R1, C1) and (R2, C2).
      inf.nextLine();
      R1 = inf.nextInt(); C1 = inf.nextInt();
      R2 = inf.nextInt(); C2 = inf.nextInt();

      //Exceptions.
      } catch (FileNotFoundException ex){
        System.out.println("Yikes");
      } catch (IOException ex){
        System.out.println("Yikes");
      }
  }

  //Update the cow??
  public static int[][] updateCow(int[][] original){
    moveGrid = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++){
        for (int j = 0; j < original[0].length; j++){
          if (original[i][j] != -1){

          if (i + 1 < original.length && original[i + 1][j] > 0){ moveGrid[i][j] += original[i + 1][j];}
          if (i - 1 >= 0 && original[i - 1][j] > 0){ moveGrid[i][j] += original[i - 1][j];}
          if (j + 1 < original[0].length && original[i][j + 1] > 0){ moveGrid[i][j] += original[i][j + 1];}
          if (j - 1 >= 0 && original[i][j - 1] > 0){ moveGrid[i][j] += original[i][j - 1];}

          } else {
            moveGrid[i][j] = -1;
          }
        }
      }
      return moveGrid;
    }

  //Full silver method.
  public static int silver(String filename)throws FileNotFoundException, IOException{
    readFileSilver(filename);
    pasture[R1 - 1][C1 - 1] = 1;
    for(int i = 0; i < T; i++) {
      pasture = updateCow(pasture);
    }
    return pasture[R2 - 1][C2 - 1];
  }

    public static void main(String[] args)throws FileNotFoundException, IOException{
      System.out.println(silver("ctravel.4.in"));
    }
  }
