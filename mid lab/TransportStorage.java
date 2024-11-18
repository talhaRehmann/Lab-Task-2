import java.util.ArrayList;
import java.util.List;

public class TransportStorage implements Observer {
    private List<String> data = new ArrayList<>();

    @Override
    public void update(String state) {
        data.add(state);
        System.out.println("Transport Storage updated with: " + state);
    }

    public List<String> getData() {
        return data;
    }
}

