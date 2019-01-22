package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.exception.UserAlreadltExistsException;
import com.stackroute.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.muzixapp.domain.Track;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServicesImpl implements TrackServices {
    private TrackRepository trackRepository;
    private Track track;
    @Autowired
    TrackServicesImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }
    @Override
    public Track saveTrack(Track track) throws UserAlreadltExistsException {
        if(trackRepository.existsById(track.getId()))
        {
            throw new UserAlreadltExistsException("track already exist");
        }
        else
        {
            Track savedtrack=trackRepository.save(track);
            return savedtrack;
        }

    }

    @Override
    public List<Track> getAllTrack() {
        List<Track> alltrack=trackRepository.findAll();
        return alltrack;
    }

    @Override
    public Track updateTrack(Track track) {
        Track updatedtrack;
        //if(trackRepository.existsById(track.getId()))
            track.setName(track.getName());
        track.setComment(track.getComment());
            updatedtrack=trackRepository.save(track);
        //else
        return updatedtrack;
    }

    @Override
    public Track removeTrack(int id) throws TrackNotFoundException {
        if(trackRepository.existsById(track.getId()))
        {
            trackRepository.deleteById(id);
        }
        else{
throw new TrackNotFoundException("Track not found");
        }
        return track;
    }
}
