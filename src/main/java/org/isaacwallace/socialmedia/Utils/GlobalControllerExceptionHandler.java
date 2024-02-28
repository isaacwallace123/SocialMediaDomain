package org.isaacwallace.socialmedia.Utils;

import lombok.extern.slf4j.Slf4j;
import org.isaacwallace.socialmedia.Utils.Exceptions.HttpErrorInfo;
import org.isaacwallace.socialmedia.Utils.Exceptions.InUseException;
import org.isaacwallace.socialmedia.Utils.Exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    private HttpErrorInfo createHttpErrorInfo(HttpStatus httpStatus, WebRequest req, Exception ex){
        final String path = req.getDescription(false);
        final String message = ex.getMessage();
        log.debug("[HttpErrorInfo] New Error: {} status at {} : {}", httpStatus, path, message);
        return new HttpErrorInfo(httpStatus, path, message);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public HttpErrorInfo handleNotFoundException(WebRequest req, Exception ex){
        return createHttpErrorInfo(HttpStatus.NOT_FOUND, req, ex);
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InUseException.class)
    public HttpErrorInfo handleInUse(WebRequest request, Exception ex){
        return createHttpErrorInfo(HttpStatus.UNPROCESSABLE_ENTITY, request, ex);
    }
}

