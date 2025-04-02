import java.util.HashMap;
import java.util.Map;

public class Runner {
    
    public Runner() {
        Map<String, Integer> settings = new HashMap<>();
        settings.put("Difficulty", 1);
        settings.put("Bot enabled", 0);

        Main.main(settings);
    }

    public static void main(String[] args) {
        new Runner();
    }
}
