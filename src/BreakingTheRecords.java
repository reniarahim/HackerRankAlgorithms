import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

public class BreakingTheRecords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = breakingRecords(scores);

/*        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );*/

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int highestScore = scores.get(0);
        int lowestScore = scores.get(0);
        int highestCount=0, lowestCount=0;
        List<Integer> scoreCountList = new ArrayList<>();

        for(int i=1;i<scores.size();i++){
            int currentScore = scores.get(i);
            if(currentScore > highestScore){
                highestScore = currentScore;
                highestCount++;
            }
            if(currentScore < lowestScore){
                lowestScore = currentScore;
                lowestCount++;
            }
        }
        scoreCountList.add(highestCount);
        scoreCountList.add(lowestCount);
        return scoreCountList;
    }
}
