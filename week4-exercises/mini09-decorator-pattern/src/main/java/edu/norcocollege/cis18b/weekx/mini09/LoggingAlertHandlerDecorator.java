package edu.norcocollege.cis18b.weekx.mini09;

public class LoggingAlertHandlerDecorator implements AlertHandler {

    private AlertHandler handler;

    public LoggingAlertHandlerDecorator(AlertHandler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(Alert alert) {
        System.out.println("LOG: Alert received");
        handler.handle(alert);
        System.out.println("LOG: Alert processed");
    }
}
