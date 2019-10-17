package com.stackroute.muzixApp.muzixController;

import com.stackroute.muzixApp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApp.exceptions.TrackNotFoundException;
import com.stackroute.muzixApp.muzix.Muzix;
import com.stackroute.muzixApp.muzixService.MuzixService;
import io.swagger.annotations.Api;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/muzix")
//@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class MuzixController {


    private MuzixService muzixService;


    @Autowired
    public MuzixController( @Qualifier("DummyMuzixServiceImpl") MuzixService muzixService)
    {
        this.muzixService=muzixService;
    }

    @PostMapping("save")
    public ResponseEntity<?> saveTrack(@RequestBody Muzix muzix) throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;
        muzixService.saveTrack(muzix);
        responseEntity=new ResponseEntity<String>("saved successfully", HttpStatus.CREATED);
//        try{
//            muzixService.saveTrack(muzix);
//            responseEntity=new ResponseEntity<String>("saved successfully", HttpStatus.CREATED);
//        }
//        catch(TrackAlreadyExistsException e){
//            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
//        }

        return responseEntity;
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteTrack(@RequestBody Muzix muzix) throws TrackNotFoundException {
        ResponseEntity responseEntity;

        int id=muzix.getTrackId();
        muzixService.deleteTrack(id);
        responseEntity=new ResponseEntity<String>("successfully deleted",HttpStatus.ACCEPTED);

//
//          try{
//              muzixService.deleteTrack(id);
//            responseEntity=new ResponseEntity<String>("successfully deleted",HttpStatus.ACCEPTED);
//          }
//           catch(TrackNotFoundException e) {
//               responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
//           }

        return responseEntity;
    }

    @GetMapping("display")
    public ResponseEntity<?> displayTracks(){
        ResponseEntity responseEntity;
        responseEntity=new ResponseEntity<List<Muzix>>(muzixService.displayTracks(),HttpStatus.FOUND);
//        try{
//
//            responseEntity=new ResponseEntity<List<Muzix>>(muzixService.displayTracks(),HttpStatus.FOUND);
//        }
//        catch(Exception e)
//        {
//            responseEntity=new ResponseEntity<String>("tracks are not found",HttpStatus.CONFLICT);
//        }
        return responseEntity;

    }

    @PutMapping("update")
    public ResponseEntity<?> saveOrUpdateTrack(@RequestBody Muzix muzix) throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;

        muzixService.saveTrack(muzix);
        responseEntity=new ResponseEntity<String>("updated successfully", HttpStatus.CREATED);
//        try{
//            muzixService.saveTrack(muzix);
//            responseEntity=new ResponseEntity<String>("updated successfully", HttpStatus.CREATED);
//        }
//        catch(TrackAlreadyExistsException e){
//            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
//        }

        return responseEntity;
    }

    @RequestMapping("search/{trackName}")
    public ResponseEntity<?> searchByName(@PathVariable("trackName") String trackName) throws TrackNotFoundException {

        ResponseEntity responseEntity;

        Muzix muzix = muzixService.search(trackName);
        responseEntity=new ResponseEntity<Muzix>(muzix,HttpStatus.FOUND);

//        try {
//            Muzix muzix = muzixService.search(trackName);
//            responseEntity=new ResponseEntity<Muzix>(muzix,HttpStatus.FOUND);
//        }
//        catch(TrackNotFoundException e){
//            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
//        }


        return responseEntity;
    }
}
