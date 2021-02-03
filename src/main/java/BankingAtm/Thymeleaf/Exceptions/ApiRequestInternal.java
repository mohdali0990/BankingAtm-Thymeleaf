package BankingAtm.Thymeleaf.Exceptions;

public class ApiRequestInternal extends RuntimeException {

    public ApiRequestInternal(String message) {
        super(message);
    }
}
