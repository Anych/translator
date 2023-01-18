package learn.words.controller.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomKey {
    public static String getRandomKey(Map<String, String> words) {
        Random random = new Random();
        List<String> keys = new ArrayList<>(words.keySet());
        return keys.get(random.nextInt(keys.size()));
    }
}
