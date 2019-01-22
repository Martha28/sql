package com.stackroute.muzixapp.applicationlistener;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.TrackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerDemo implements ApplicationListener<ContextRefreshedEvent> {

     private TrackRepository trackRepository;

    @Autowired
    public ApplicationListenerDemo(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        Track track=Track.builder().name("Durga22").comment("Martha").build();
//        trackRepository.save(track);
//        Track track1=Track.builder().name("vinay gadha").comment("idiot").build();
//        trackRepository.save(track1);

    }
}
