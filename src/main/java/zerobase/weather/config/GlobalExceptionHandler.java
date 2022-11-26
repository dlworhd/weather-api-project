package zerobase.weather.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //예외가 발생한 시점이 클라이언트에서 서버 API를 호출한 시점에 에러가 발생할 수도 있는데 그걸 @ResponseStatus로 해결 500번 에러
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Exception handleAllException(){
        System.out.println("error from GlobalExceptionHandler");
        return new Exception();
    }
}
