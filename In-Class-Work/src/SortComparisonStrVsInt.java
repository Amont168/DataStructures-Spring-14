
public class SortComparisonStrVsInt {
    public static void main(String[] args) 
    {
        int listA[] = {1,3,5,7,9,11,13,15};
        int listB[] = {2,4,6,8,10,12,14,16};
        int listC[] = new int[20];
        
        
        filler(listA, listB, listC, 0);
        filler(listA, listB, listC, 1);
        filler(listA, listB, listC, 2);
        filler(listA, listB, listC, 3);
        filler(listA, listB, listC, 4);
        filler(listA, listB, listC, 5);
        filler(listA, listB, listC, 6);
        filler(listA, listB, listC, 7);
        //filler(listA, listB, listC, 8);
        //filler(listA, listB, listC, 9);
        //filler(listA, listB, listC, 10);
        //filler(listA, listB, listC, 11);
        //filler(listA, listB, listC, 12);
        //filler(listA, listB, listC, 13);
        //filler(listA, listB, listC, 14);
        //filler(listA, listB, listC, 15);
        //filler(listA, listB, listC, 16);
        //filler(listA, listB, listC, 17);
        //filler(listA, listB, listC, 18);
        //filler(listA, listB, listC, 19);
        
        //listC[0 ] = listA[0];
        //listC[1 ] = listB[0];
        //listC[2 ] = listA[1];
        //listC[3 ] = listB[1];
        //listC[4 ] = listA[2];
        //listC[5 ] = listB[2];
        //listC[6 ] = listA[3];
        //listC[7 ] = listB[3];
        //listC[8 ] = listA[4];
        //listC[9 ] = listB[4];
        //listC[10] = listA[5];
        //listC[11] = listB[5];
        //listC[12] = listA[6];
        //listC[13] = listB[6];
        //listC[14] = listA[7];
        //listC[15] = listB[7];
        
        for(int x = 0 ; x < 16; x++)
        {
            System.out.println(listC[x]);
        }
    }
    
    private static void filler(int[] listA, int[] listB, int[] listC, int i)
    {
        if(listC[0] == 0)
        {
            listC[0 ] = listA[0];
            listC[1 ] = listB[0];
        }
        else
        {
            int X = 1;
            int tracker = 0;
            while(X!=0)
            {
                X = listC[tracker];
                tracker++;
            }
            tracker--;
            if(listA[i]!=0)
            {
               listC[tracker] = listA[i]; 
            }
            if(listB[i]!=0)
            {
                listC[tracker+1] = listB[i];
            }
        }
    }

}
