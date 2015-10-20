import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class censusSoter {
    public static void main(String[] args) throws IOException {
    
        
        FileReader fr = new FileReader("census-names-unsorted.txt");
        
        BufferedReader br = new BufferedReader(fr);
        
        String holder = "";
        
        String[] array = new String[90000];
        
        int x = 0;
        
        while((holder=br.readLine())!=null)
        {
            array[x] = holder;
            x++;
        }
        
        System.out.println("Tester1");
        
        for(int counter1 = 0; counter1 <= 88796; counter1++)
        {
            for(int counter2 = 0; counter2 <= 88796; counter2++)
            {
                if(((int)array[counter2].charAt(0)) > ((int)array[counter2+1].charAt(0)))
                {
                    String temp = array[counter2];
                    array[counter2] = array[counter2+1];
                    array[counter2+1] = temp;
                }
            }
            System.out.println("Loading....");
        }
        
        System.out.println("Loaded!");
        
        for(int counter3 = 0; counter3 <= 88796; counter3++)
        {
            System.out.println(array[counter3]);
        }
        

    }

}
