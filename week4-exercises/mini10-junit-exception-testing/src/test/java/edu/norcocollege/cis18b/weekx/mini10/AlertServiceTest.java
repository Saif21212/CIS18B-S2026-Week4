package edu.norcocollege.cis18b.weekx.mini10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlertServiceTest {

    @Test
    void shouldStoreSuccessfullyProcessedAlert() throws Exception {
        InMemoryAlertRepository repo = new InMemoryAlertRepository();
        AlertService service = new AlertService(repo);
        Alert alert = new Alert(1, "Unauthorized login attempt", AlertLevel.CRITICAL);

        // Process the alert
        service.process(alert);

        // Assert that one alert was stored
        assertEquals(1, repo.getAllAlerts().size());
    }

    @Test
    void shouldThrowWhenRepositoryFails() {
        AlertService service = new AlertService(new AlwaysFailRepository());
        Alert alert = new Alert(2, "Disk failure", AlertLevel.CRITICAL);

        // Expect exception when processing
        assertThrows(AlertStorageException.class, () -> {
            service.process(alert);
        });
    }
}
