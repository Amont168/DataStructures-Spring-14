import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class NameSort {

    public static void main() throws IOException{
        
        
        FileReader fr = new FileReader("census-names-unsorted.txt");
        
        BufferedReader br = new BufferedReader(fr);
        
        String holder = "";
        
        while((br.readLine() != null))
        {
            System.out.println(br);
        }
    }
}
