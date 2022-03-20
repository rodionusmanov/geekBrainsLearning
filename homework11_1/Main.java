package homework11_1;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] strings = {"a", "a", "b", "a", "vc", "a", "vc", "c", "b", "ds", "a", "vc", "c", "b", "ds","a", "c", "r", "v", "x"};
        Map<String, Integer> words = new HashMap<>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            if (!words.containsKey(strings[i])) {
                words.put(strings[i], 1);
            } else {
                words.replace(strings[i], words.get(strings[i]) + 1);
            }
        }
        System.out.println(words);
    }
}

