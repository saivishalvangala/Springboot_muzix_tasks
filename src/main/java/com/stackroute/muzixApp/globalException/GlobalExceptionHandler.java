package com.stackroute.muzixApp.globalException;

import com.stackroute.muzixApp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApp.exceptions.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<?> fileNotFound(TrackNotFoundException e){
        System.out.println("hi iam in Tracknot found exception");
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity<?> trackAlreadyExists(TrackAlreadyExistsException e){
        System.out.println("hi iam in track already exception ");
        return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e){
        System.out.println("General Exception");
        return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }


}
