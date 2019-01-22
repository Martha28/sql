package com.stackroute.muzixapp.commandline;


import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;
import com.stackroute.muzixapp.service.TrackServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public void run(String... args) throws Exception {
        trackRepository.save(new Track(1,"song1","comment"));
        trackRepository.save(new Track(2,"song2","comment"));
        trackRepository.save(new Track(3,"song3","comment"));
    }
}