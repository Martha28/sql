package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exception.TrackNotFoundException;
import com.stackroute.muzixapp.exception.UserAlreadltExistsException;

import java.util.List;

public interface TrackServices {
    public Track saveTrack(Track track) throws UserAlreadltExistsException;
    public List<Track> getAllTrack();
    public Track updateTrack(Track track);
    public Track removeTrack(int id) throws TrackNotFoundException;
}
