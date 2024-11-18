public class UniversityTransportSystem {
    private static Observer logger;
    
        public static void main(String[] args) {
            // Step 1: Create the Subject (main application that controls the transport system)
            Subject subject = new Subject();
    
            // Step 2: Create the Observers (BusSchedule, StudentCheck, Logger, TransportStorage)
            BusSchedule busSchedule1 = new BusSchedule("Bus1", "Main Campus - South Campus");
            BusSchedule busSchedule2 = new BusSchedule("Bus2", "Main Campus - North Campus");
    
            StudentCheck student1 = new StudentCheck("S001", "Alice");
            StudentCheck student2 = new StudentCheck("S002", "Bob");
    
            TransportStorage transportStorage = new TransportStorage();
    
            // Step 3: Add Observers to the Subject (so they will be notified of changes)
            subject.addObserver(busSchedule1);
            subject.addObserver(busSchedule2);
            subject.addObserver(student1);
            subject.addObserver(student2);
            subject.addObserver(logger);
        subject.addObserver(transportStorage);

        // Step 4: Simulate some updates to the system

        // Update 1: Bus Schedule (State change)
        String busScheduleUpdate = "Bus 1 arrives at 8:00 AM, Bus 2 arrives at 9:00 AM";
        subject.setState(busScheduleUpdate); // Notify observers with new state

        // Update 2: Student Registration (State change)
        String studentRegistrationUpdate = "Student Alice registers for Bus 1";
        subject.setState(studentRegistrationUpdate); // Notify observers with new state

        // Update 3: Payment Processing (State change)
        String paymentUpdate = "Student Alice pays for the bus";
        subject.setState(paymentUpdate); // Notify observers with new state

        // Update 4: Log the final status (State change)
        String finalStatusUpdate = "All systems processed successfully";
        subject.setState(finalStatusUpdate); // Notify observers with new state

        // Step 5: Optionally, you can print the logs from the logger and transport storage to see the final results
        System.out.println("\n--- Final Logs ---");
        for (String log : logger.getLogs()) {
            System.out.println(log);
        }

        System.out.println("\n--- Final Transport Data ---");
        for (String data : transportStorage.getData()) {
            System.out.println(data);
        }
    }
}
