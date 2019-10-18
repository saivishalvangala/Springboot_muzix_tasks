package com.stackroute.muzixApp.muzixController;

import com.stackroute.muzixApp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApp.exceptions.TrackNotFoundException;
import com.stackroute.muzixApp.muzix.Muzix;
import com.stackroute.muzixApp.muzixService.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/muzixapp")
//@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class MuzixController {


    private MuzixService muzixService;


    @Autowired
    public MuzixController( @Qualifier("DummyMuzixServiceImpl") MuzixService muzixService)
    {
        this.muzixService=muzixService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Muzix muzix) throws TrackAlreadyExistsException, Exception{
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

    @DeleteMapping("track")
    public ResponseEntity<?> deleteTrack(@RequestBody Muzix muzix) throws TrackNotFoundException,Exception{
        ResponseEntity responseEntity;

        int id=muzix.getTrackId();
        Muzix muzix1= muzixService.deleteTrack(id);
        responseEntity=new ResponseEntity<String>("successfully deleted the below track: "+muzix1,HttpStatus.ACCEPTED);

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

    @GetMapping("tracks")
    public ResponseEntity<?> displayTracks()throws TrackNotFoundException ,Exception{
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

    @PutMapping("track")
    public ResponseEntity<?> saveOrUpdateTrack(@RequestBody Muzix muzix) throws TrackAlreadyExistsException,Exception {
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

    @RequestMapping("track/{trackName}")
    public ResponseEntity<?> searchByName(@PathVariable("trackName") String trackName) throws TrackNotFoundException ,Exception{

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
