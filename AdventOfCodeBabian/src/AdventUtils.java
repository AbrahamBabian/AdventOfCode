import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventUtils
{
    public static String inputToString(File input) throws FileNotFoundException
    {
        Scanner reader = new Scanner(input);
        String string = "";
        while(reader.hasNext()) string += reader.nextLine() + "\n";
        return string;
    }


}
