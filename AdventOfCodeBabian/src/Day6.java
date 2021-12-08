import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day6
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("C:\\Users\\AbrahamBabian\\IdeaProjects\\AdventOfCodeBabian\\src\\Day6Input.txt");
        Scanner reader = new Scanner(file);
        String input = reader.nextLine();
        List<String> fishes = new ArrayList<String>(Arrays.asList(input.split(",")));
        ArrayList<Integer> fishesInt = new ArrayList<Integer>();
        int lastIndex = fishes.size();
        for(int f = 0; f < lastIndex; f++) fishesInt.add(Integer.parseInt(fishes.get(f)));
        //System.out.println(partOne(fishesInt));
        System.out.println(partTwo(fishesInt));
    }

    public static int partOne(ArrayList<Integer> input)
    {
        int lastIndex = input.size();

        for(int i = 0; i < 80; i++)
        {
            for(int f = 0; f < lastIndex; f++)
            {
                if(input.get(f) == 0)
                {
                    input.set(f,6);
                    input.add(8);
                }
                else input.set(f, input.get(f) - 1);

            }
            lastIndex = input.size();
        }

        return lastIndex;
    }

    public static BigInteger partTwo(ArrayList<Integer> input) {

        BigInteger[] array = new  BigInteger[9];
        BigInteger day0,day1,day2,day3,day4,day5,day6,day7,day8;
        for(int i = 0; i < array.length; i++) array[i] = BigInteger.valueOf(0);
        for (var days : input)
        {
            System.out.println(days);
            array[days] = array[days].add(BigInteger.valueOf(1));
            System.out.println(Arrays.toString(array));
        }

        for (int i = 0; i < 256; i++)
        {
            day0 = array[0];
            day1 = array[1];
            day2 = array[2];
            day3 = array[3];
            day4 = array[4];
            day5 = array[5];
            day6 = array[6];
            day7 = array[7];
            day8 = array[8];

            array[8] = day0;
            array[7] = day8;
            array[6] = day7;
            array[6] = array[6].add(day0);
            array[5] = day6;
            array[4] = day5;
            array[3] = day4;
            array[2] = day3;
            array[1] = day2;
            array[0] = day1;
            System.out.println(Arrays.toString(array));
        }
        BigInteger sum = BigInteger.valueOf(0);
        for(int i = 0; i < array.length; i++)
            sum = sum.add(array[i]);
        return sum;

    }


}
