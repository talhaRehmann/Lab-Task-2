public class StudentCheck implements Observer {
    private String studentId;
    private String name;

    public StudentCheck(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Override
    public void update(String state) {
        System.out.println("Student " + name + " (" + studentId + ") received the update: " + state);
        if (state.toLowerCase().contains("register")) {
            System.out.println("Student " + name + " is registered for the bus.");
        }
    }
}

