package com.stackroute.muzixapp.controller;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.exception.UserAlreadltExistsException;
import com.stackroute.muzixapp.service.TrackServices;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@Api(value = "HelloWorld Resource", description = "shows hello world")
public class TrackController {
    TrackServices trackService;
    ResponseEntity responseEntity;
    public TrackController(TrackServices userService){
        this.trackService=userService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws UserAlreadltExistsException {


        try {
            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<String>("Sucessfully created", HttpStatus.CREATED);
        } catch (UserAlreadltExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTrack(){
        return new ResponseEntity<List<Track>>(trackService.getAllTrack(),HttpStatus.OK);
    }
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track){
        trackService.updateTrack(track);
        responseEntity=new ResponseEntity<String>("Sucessfully updated", HttpStatus.CREATED);
        return responseEntity;
    }
    @DeleteMapping("track")
    public ResponseEntity<?> removeTrack(@PathVariable("id")int id) throws TrackNotFoundException {
        trackService.removeTrack(id);
        responseEntity=new ResponseEntity<String>("deleted", HttpStatus.OK);
        return responseEntity;
    }
}

