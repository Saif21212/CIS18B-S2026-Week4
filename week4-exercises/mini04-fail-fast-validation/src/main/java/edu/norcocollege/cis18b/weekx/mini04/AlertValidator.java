public void validate(Alert alert) throws InvalidAlertException {
    if (alert == null) {
        throw new InvalidAlertException("Alert cannot be null.");
    }

    if (alert.getMessage() == null || alert.getMessage().isBlank()) {
        throw new InvalidAlertException("Message cannot be empty.");
    }

    if (alert.getLevel() == null) {
        throw new InvalidAlertException("Alert level cannot be null.");
    }
}
