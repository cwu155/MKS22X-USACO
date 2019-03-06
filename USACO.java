import java.util.*;
import java.io.*;

public class USACO{

  public static int[][] map;
  public static int r, c, e, n;

  public static void readFile(String filename) throws FileNotFoundException, IOException{
    try {
      File text = new File(filename);
      Scanner inf = new Scanner(text);

      BufferedReader brTest = new BufferedReader(new FileReader(filename));
      String firstLine = brTest.readLine();

      r = Integer.parseInt(firstLine.substring(0,1));
      c = Integer.parseInt(firstLine.substring(2,3));
      //e = Integer.parseInt(firstLine.substring(4,5));
      //n = Integer.parseInt(firstLine.substring(4,5));

      //   while(inf.hasNextLine()){
      //     String line = inf.nextLine();
      //     rows += 1;
      //   }
      //
      //   maze = new char[rows][];
      //   rows = 0;
      //
      // File text1 = new File(filename);
      // Scanner inf1 = new Scanner(text1);
      //
      //   while(inf1.hasNextLine()){
      //     String next = inf1.nextLine();
      //     maze[rows] = next.toCharArray();
      //     rows += 1;
      //   }

      } catch (FileNotFoundException ex){
        System.out.println("Yikes");
      } catch (IOException ex){
        System.out.println("Yikes");
      }
    }

    public static void main(String[] args)throws FileNotFoundException, IOException{
      readFile("makelake.in");
      System.out.println(r);
      System.out.println(c);
    }
  }
