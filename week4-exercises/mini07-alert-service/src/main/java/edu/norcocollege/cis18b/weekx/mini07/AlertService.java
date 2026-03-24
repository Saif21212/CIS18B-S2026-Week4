public class AlertService {

    private AlertValidator validator = new AlertValidator();
    private AlertRepository repository = new InMemoryAlertRepository();

    public void process(Alert alert) throws AlertProcessingException {
        try {
            // Step 1: Validate
            validator.validate(alert);

            // Step 2: Save
            repository.saveAlert(alert);

            System.out.println("Alert processed successfully.");

        } catch (InvalidAlertException e) {
            // Validation failed
            throw new AlertProcessingException("Invalid alert.", e);

        } catch (AlertStorageException e) {
            // Storage failed
            throw new AlertProcessingException("Failed to store alert.", e);
        }
    }
}
