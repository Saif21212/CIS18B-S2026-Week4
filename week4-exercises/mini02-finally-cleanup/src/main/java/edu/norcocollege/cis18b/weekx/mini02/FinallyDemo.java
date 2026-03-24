package edu.norcocollege.cis18b.weekx.mini02;

public class FinallyDemo {
    public static void main(String[] args) {

        System.out.println("Opening alert stream...");

        try {
            throw new RuntimeException("Stream connection failed");
        } catch (RuntimeException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            System.out.println("Closing alert stream...");
        }
    }
}
