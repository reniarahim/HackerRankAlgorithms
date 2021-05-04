import java.io.*;

public class TimeConversion {

    public static String timeConversion(String s) {
        String AMPM = s.substring(8,10);
        String Hh = s.substring(0,2);
        String Mm = s.substring(3,5);
        String Ss = s.substring(6,8);
        int HhInt = Integer.parseInt(Hh);
        String HhNewString="  ";

        if(AMPM.equals("PM")){
            if(HhInt == 12){
                HhNewString="12";
            }
            else{
                HhInt = HhInt+12;
                HhNewString = String.valueOf(HhInt);
            }

        }
        else if(AMPM.equals("AM")){
            if(HhInt == 12){
                HhNewString="00";
            }
            else {
                HhNewString = Hh;
            }
        }
        String TimeNew = HhNewString+":"+Mm+":"+Ss;
        return TimeNew;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);
        System.out.println(result);

        //bufferedWriter.write(result);
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
