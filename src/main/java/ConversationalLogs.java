import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

public class ConversationalLogs {


    public static List<String> outputLogs(String s) {
        List<String> lines = Arrays
                .stream(s.split("[\\n]+"))
                .collect(Collectors.toList());

        List<List<String>> words = lines
                .stream()
                .map(w -> Arrays
                        .stream(w.toString()
                                .split("[\\s@&.?$+-]+"))
                        .skip(1)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        List<String> combinedList = words.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());


        Map<String, Long> counter = combinedList
                .stream()
                .filter(e -> Collections.frequency(combinedList, e) > 1)
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        List<String> keys = counter
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(x -> x.getKey())
                .collect(Collectors.toList());

        List<Long> values = counter
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(x -> x.getValue())
                .collect(Collectors.toList());

        int left = 0;
        int right = values.size() - 1;

        while (left < right) {
            if (values.get(left) == values.get(right)) {
                if (keys.get(left).compareTo(keys.get(right)) > 0) {
                    String temp = keys.get(left);
                    keys.set(left, keys.get(right));
                    keys.set(right, temp);
                    right--;
                }

            }else{
                left++;
            }


        }

        if (keys.size() == 0) {
            keys.add("ALL CLEAR");
        }

        return keys;
    }




    public static void main(String[] args) {
        String s = "Jepson no no no no nobody never\n" +
                "Ashley why ever not\n" +
                "Marcus no not never nobody\n" +
                "Bazza no never know nobody\n" +
                "Hatty why no nobody\n" +
                "Hatty nobody never know why nobody\n" +
                "Jepson never no nobody\n" +
                "Ashley never never nobody no";
        System.out.println(outputLogs(s));
    }
}
