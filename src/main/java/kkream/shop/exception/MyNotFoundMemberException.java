package kkream.shop.exception;

public class MyNotFoundMemberException extends RuntimeException{
    public MyNotFoundMemberException() {
        super();
    }

    public MyNotFoundMemberException(String message) {
        super(message);
    }

    public MyNotFoundMemberException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyNotFoundMemberException(Throwable cause) {
        super(cause);
    }

    protected MyNotFoundMemberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
