import java.util.ArrayList;
import java.util.List;

public class logger implements Observer {
    private List<String> logs = new ArrayList<>();

    @Override
    public void update(String state) {
        logs.add(state);
        System.out.println("Logger: " + state);
    }

    public List<String> getLogs() {
        return logs;
    }
}
