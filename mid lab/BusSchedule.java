public class BusSchedule implements Observer {
    private String busId;
    private String route;

    public BusSchedule(String busId, String route) {
        this.busId = busId;
        this.route = route;
    }

    @Override
    public void update(String state) {
        System.out.println("Bus Schedule Update: Bus " + busId + " on route " + route + " - " + state);
    }
}
