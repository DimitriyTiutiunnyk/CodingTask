package CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/*
Time the program began: "yyyy-MM-dd HH:mm:ss"
The number of entries: 120
The average latency time: 112.20
Time the program ended: "yyyy-MM-dd HH:mm:ss"
 */

public class Task {

    private static final SimpleDateFormat dhg = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static double getTime(Timestamp ts){
        String time = ts.toString();


        int idx = time.lastIndexOf(':');
        String d = time.substring(idx+1);
        double s = Double.valueOf(d);
        return s;
    }

    public static void main(String[] args) {

        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String time = ts.toString();

        System.out.println("Time the program began: " + time);

        double s = getTime(ts);

        String csvFile = "/Users/dmitriytiutiunnyk/IdeaProjects/CodingTask/src/test/java/jmeter_results.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\n";
        int count = 0;



        try {

            br = new BufferedReader(new FileReader(csvFile));

            while((line=br.readLine())!=null){
                count++;
            }

//            while ((line = br.readLine()) != null) {
//
//
//                String[] aahasl = line.split(cvsSplitBy);
//                int count = aahasl.length;
//                System.out.println(count);
//
//
//
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("The number of entries: " + --count);

        double e = getTime(new Timestamp(System.currentTimeMillis()));
        System.out.println("The average latency time: " + (e-s)/count);

        System.out.println("Time the program ended: " + new Timestamp(System.currentTimeMillis()));
    }

}