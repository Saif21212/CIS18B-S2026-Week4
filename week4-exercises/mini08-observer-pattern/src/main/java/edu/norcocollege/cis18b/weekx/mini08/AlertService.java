import java.util.ArrayList;
import java.util.List;

public class AlertService {

    private List<AlertObserver> observers = new ArrayList<>();

    // Add observer
    public void addObserver(AlertObserver observer) {
        observers.add(observer);
    }

    // Remove observer
    public void removeObserver(AlertObserver observer) {
        observers.remove(observer);
    }

    // Notify all observers
    private void notifyObservers(Alert alert) {
        for (AlertObserver observer : observers) {
            observer.onAlert(alert);
        }
    }

    // Process alert and notify
    public void process(Alert alert) {
        System.out.println("Processing alert: " + alert.getMessage());

        // Notify observers
        notifyObservers(alert);
    }
}
