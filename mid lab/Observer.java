public interface Observer {
    void update(String state);

    String[] getLogs();
}
