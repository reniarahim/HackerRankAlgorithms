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



public class GradingStudents {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        for(int i=0;i<grades.size();i++){

            if(grades.get(i)>=38){
                if(grades.get(i)%5 >=3)
                {
                    int value = grades.get(i);
                    int toAdd = 5 - (value%5);
                    grades.set(i,(value+toAdd));
                }
            }
        }
        return grades;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = gradingStudents(grades);

        //bufferedWriter.write(
        //        result.stream()
        //                .map(Object::toString)
        //                .collect(joining("\n"))
        //                + "\n"
        //);

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

