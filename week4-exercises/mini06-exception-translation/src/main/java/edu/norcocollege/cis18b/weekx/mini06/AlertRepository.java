public void saveAlert(Alert alert) throws AlertStorageException {
    try {
        // Simulate a failure (like database error)
        throw new RuntimeException("Database connection failed");

    } catch (RuntimeException ex) {
        // Translate to custom exception
        throw new AlertStorageException("Failed to save alert", ex);
    }
}
