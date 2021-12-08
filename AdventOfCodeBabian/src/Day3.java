import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day3
{

    public static int solutionPartOne(Scanner reader)
    {
        String input = reader.nextLine();
        int[] array = new int[input.length()];

        for(int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == '1')
                array[i]++;
            else array[i]--;
        }

        while(reader.hasNextLine())
        {
            input = reader.nextLine();
            for(int i = 0; i < input.length(); i++)
            {
                if (input.charAt(i) == '1')
                    array[i]++;
                else array[i]--;
            }
        }
        String gamma = "";
        System.out.println(Arrays.toString(array));
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] > 0)
                gamma += "1";
            else gamma += "0";
        }
        String epsilon = "";
        for(int i = 0; i < gamma.length(); i++)
            if(gamma.charAt(i) == '1')
                epsilon += '0';
            else epsilon += '1';
        return Integer.parseInt(gamma,2) * Integer.parseInt(epsilon,2);


    }

    public static String oxygenGeneratorRating(Scanner reader)
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        int count = 0;
        char c;
        while(reader.hasNext())
            arrayList.add(reader.nextLine());
        System.out.println(arrayList.toString());
        int length = arrayList.get(0).length();
        for(int i = 0; i < length; i++)
        {
            for(int f = 0; f < arrayList.size(); f++)
            {
                if (arrayList.get(f).charAt(i) == '1')
                    count++;
                else count--;
            }

            for(int f = 0; f < arrayList.size(); f++)
            {
                c = arrayList.get(f).charAt(i);
                if((count > 0 && c == '0') || (count < 0 && c == '1'))
                {
                    arrayList.remove(f);
                    f--;
                }
                else if (count == 0 && c == '0')
                {
                    arrayList.remove(f);
                    f--;
                }
            }
            if (arrayList.size() == 1)
                return arrayList.get(0);
            count = 0;
        }
        System.out.println(arrayList.toString());
        return arrayList.get(0);
    }

    public static String CO2ScruberRating(Scanner reader)
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        int count = 0;
        char c;
        while(reader.hasNext())
            arrayList.add(reader.nextLine());
        System.out.println(arrayList.toString());
        int length = arrayList.get(0).length();
        for(int i = 0; i < length; i++)
        {
            for(int f = 0; f < arrayList.size(); f++)
            {
                if (arrayList.get(f).charAt(i) == '1')
                    count++;
                else count--;
            }

            for(int f = 0; f < arrayList.size(); f++)
            {
                c = arrayList.get(f).charAt(i);
                if((count > 0 && c == '1') || (count < 0 && c == '0'))
                {
                    arrayList.remove(f);
                    f--;
                }
                else if (count == 0 && c == '1')
                {
                    arrayList.remove(f);
                    f--;
                }
            }
            System.out.println(arrayList.size());
            if (arrayList.size() == 1)
                return arrayList.get(0);
            count = 0;
        }
        System.out.println(arrayList.toString());
        return arrayList.get(0);
    }

    public static int solutionPartTwo(Scanner reader, Scanner reader2)
    {
        return Integer.parseInt(oxygenGeneratorRating(reader),2) * Integer.parseInt(CO2ScruberRating(reader2),2);
    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\AbrahamBabian\\IdeaProjects\\AdventOfCodeBabian\\src\\Day3Input.txt");
        Scanner reader = new Scanner(file);
        //System.out.println(solutionPartOne(reader));
       //System.out.println(oxygenGeneratorRating(reader));
        Scanner reader2 = new Scanner(file);
        //System.out.println(CO2ScruberRating(reader2));
        System.out.println(solutionPartTwo(reader, reader2));

    }
}
