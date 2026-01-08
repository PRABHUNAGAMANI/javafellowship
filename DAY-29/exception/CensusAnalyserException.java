package exception;

public class CensusAnalyserException extends Exception {

    public enum ExceptionType {
        FILE_NOT_FOUND,
        INVALID_TYPE,
        INVALID_DELIMITER,
        STATE_NOT_FOUND, NO_SUCH_STATE, INVALID_HEADER
    }

    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
