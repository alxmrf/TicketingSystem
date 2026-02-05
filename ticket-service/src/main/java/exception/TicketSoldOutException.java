package exception;

public class TicketSoldOutException extends RuntimeException {

    // Simple constructor
    public TicketSoldOutException(String message) {
        super(message);
    }

    // Constructor with formatting support (Senior helper)
    public TicketSoldOutException(String format, Object... args) {
        super(String.format(format, args));
    }
}