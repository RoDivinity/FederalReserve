package federalreserve;
import java.util.*;
import java.io.*;


/**
 *
 * @author Vodka
 */
public class FederalReserve {

    /**
     * @param args the command line arguments
     */
    
    public static String deDup(String s) {
    return new LinkedHashSet<String>(Arrays.asList(s.split(" "))).toString().replaceAll("(^\\[|\\]$)", "").replace(", ", ", ");
}
    
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in);
        
       // System.out.println(in);
        
        //System.out.println("the years are: " + years);
       
        
        Map table = new HashMap<Integer, String>();
        ArrayList year_index = new ArrayList<Integer> ();
        String[] country = new String[28];
        //int n =0;
        for (int n = 0 ; n < 27 ; n ++ )
        {
            country[n] = sc.nextLine();
            //System.out.println("Country processing "+country[n]);
            String years = sc.nextLine();
            StringTokenizer st = new StringTokenizer(years, ", ");
        while(st.hasMoreTokens())
            {
                int year = 0;
                try{
             year = Integer.parseInt(st.nextToken());
             //System.out.println("the number we got "+year);
                }
                catch(NumberFormatException ex)
                {
                //    System.out.println("what the problem? "+ ex.getMessage());
                    break;
                }
                if(!year_index.contains(year))
                    year_index.add(year);
            //System.out.println(years);
            if(!table.containsKey(year))
                table.put(year, country[n]);
            else
            {
                String update = table.get(year) + " " +country[n];
                table.put(year, update);
            }
            }
       // n++;
       // System.out.println("Scanning next input! ");
        }
        //Print out answer
        String[] out = new String[year_index.size()];
        for (int i = 0 ; i < year_index.size() ; i ++)
        {
            String ans =  year_index.get(i) + " "+table.get(year_index.get(i));
            out[i]= ans;
        }
        Arrays.sort(out);
        System.out.println("number of rows "+out.length);
        for (int j = 0 ; j < year_index.size(); j ++)
        {
            System.out.println( deDup(out[j]));
        }
       }
}
