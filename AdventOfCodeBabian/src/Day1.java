import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1
{

    public static int countIncreased(String numbers)
    {
        Scanner reader = new Scanner(numbers);
        int previous = Integer.parseInt(reader.nextLine())
                , current = Integer.parseInt(reader.nextLine())
                , count = 0;
        while(reader.hasNextLine())
        {
            if(current > previous)
            {
                count++;
            }
            previous = current;
            current = Integer.parseInt(reader.nextLine());
        }
        return current > previous ?  count +1 : count;
    }

    public static int countIncreasedTriples(ArrayList<Integer> triples)
    {
        System.out.println(triples.toString());

        int index = 0,
                previous = triples.get(index)
                , current = triples.get(++index)
                , count = 0;

        while(index < triples.size() - 1)
        {
            if(current > previous)
            {
                count++;
            }
            index++;
            previous = current;
            current = triples.get(index);
        }
        return current > previous ?  count +1 : count;
    }

    public static ArrayList<Integer> sumTriples(String numbers)
    {
        Scanner reader = new Scanner(numbers);
        ArrayList<String> numbersArray = new ArrayList<String>();
        ArrayList<Integer> sum = new ArrayList<Integer>();
        int count = 0;
        String temp = "";
        while(reader.hasNextLine())
        {
            temp = reader.nextLine();
            numbersArray.add(count, temp);
            count++;
        }
        count = 1;
        int sumIndex = 0;
        while(count < numbersArray.size() - 1)
        {
            sum.add(sumIndex,Integer.parseInt(numbersArray.get(count - 1)) + Integer.parseInt(numbersArray.get(count)) + Integer.parseInt(numbersArray.get(count + 1)));
            sumIndex++;
            count++;
        }
        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\AbrahamBabian\\IdeaProjects\\AdventOfCodeBabian\\src\\Day1Input.txt");
        String input = AdventUtils.inputToString(file);
        System.out.println(countIncreased(input)); //solution of part 1
        ArrayList<Integer> solution2 = sumTriples(AdventUtils.inputToString(file));
        System.out.println(countIncreasedTriples(solution2)); // solution of part 2
    }
}
