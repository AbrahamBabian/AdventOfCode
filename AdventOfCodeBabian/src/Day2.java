import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2
{


    public static void main(String[] args) throws FileNotFoundException
    {
        File input = new File("C:\\Users\\AbrahamBabian\\IdeaProjects\\AdventOfCodeBabian\\src\\Day2Input.txt");
        Scanner reader = new Scanner(input);
        System.out.println(multiplyHorizontalDepthV2(reader));
    }

    public static int multiplyHorizontalDepth(Scanner scanner) //Solution To Part One
    {
        String line = "";
        int[] coordinates = new int[2]; // 0 index -> horizontal, 1 -> depth
        for(int i = 0; i < 2; i++) coordinates[i] = 0;

        while(scanner.hasNextLine())
        {
            line = scanner.nextLine();

            if(line.contains("forward"))
            {
                System.out.println(line);
                line = line.replaceAll("[^0-9]+", "");
                coordinates[0] += Integer.parseInt(line);
            }
            else if(line.contains("up"))
            {
                System.out.println(line);
                line = line.replaceAll("[^0-9]+", "");
                coordinates[1] -= Integer.parseInt(line);
            }
            else if(line.contains("down"))
            {
                line = line.replaceAll("[^0-9]+", "");
                coordinates[1] += Integer.parseInt(line);
            }

        }
        System.out.println(coordinates[0] + " " + coordinates[1]);
        return coordinates[0]*coordinates[1];
    }
    public static int multiplyHorizontalDepthV2(Scanner scanner) //Solution To Part Two
    {
        String line = "";
        int[] coordinates = new int[2]; // 0 index -> horizontal, 1 -> depth
        int aim = 0;
        int temp = 0;
        for(int i = 0; i < 2; i++) coordinates[i] = 0;

        while(scanner.hasNextLine())
        {
            line = scanner.nextLine();

            if(line.contains("forward"))
            {
                line = line.replaceAll("[^0-9]+", "");
                temp = Integer.parseInt(line);
                coordinates[0] += temp;
                coordinates[1] += aim*temp;
            }
            else if(line.contains("up"))
            {
                System.out.println(line);
                line = line.replaceAll("[^0-9]+", "");
                aim -= Integer.parseInt(line);
            }
            else if(line.contains("down"))
            {
                line = line.replaceAll("[^0-9]+", "");
                aim += Integer.parseInt(line);
            }

        }
        System.out.println(coordinates[0] + " " + coordinates[1]);
        return coordinates[0]*coordinates[1];
    }

}
