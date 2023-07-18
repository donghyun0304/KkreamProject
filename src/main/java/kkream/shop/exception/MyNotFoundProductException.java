package kkream.shop.exception;

public class MyNotFoundProductException extends RuntimeException{
    public MyNotFoundProductException() {
        super();
    }

    public MyNotFoundProductException(String message) {
        super(message);
    }

    public MyNotFoundProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyNotFoundProductException(Throwable cause) {
        super(cause);
    }

    protected MyNotFoundProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
