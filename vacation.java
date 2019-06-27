import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Solution
{   
    // Method to set the Year and Month
    public static void parseDate(String date,Calendar c)throws Exception
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MMM");
        c.setTime(df.parse(date));
    }

    // Method to find the first monday of the first month
    public static void setFirstMonday(Calendar c)
    {
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
    }

    // Method to find the last sunday of the second month
    public static void setLastSunday(Calendar c)
    {
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        c.set(Calendar.DAY_OF_WEEK_IN_MONTH, -1);
    }

    // Method to find the no. of whole weeks
    public static int solution(int Y,String A,String B,String W)throws Exception
    {
        String dateOne = Y+"-"+A;
        String dateTwo = Y+"-"+B;
        
        Calendar c1 = Calendar.getInstance();
        parseDate(dateOne, c1);

        Calendar c2 = Calendar.getInstance();
        parseDate(dateTwo, c2);

        setFirstMonday(c1);
        setLastSunday(c2);

        int weeks = c2.get(Calendar.WEEK_OF_YEAR) - c1.get(Calendar.WEEK_OF_YEAR)+1; 

        return weeks;
    }

    public static void main(String args[])throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        bw.write(String.valueOf(solution(Integer.parseInt(input[0]),input[1],input[2],input[3])));
        bw.newLine();
        bw.flush();
    }
}