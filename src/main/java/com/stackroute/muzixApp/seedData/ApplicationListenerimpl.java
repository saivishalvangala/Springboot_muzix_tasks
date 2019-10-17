package com.stackroute.muzixApp.seedData;

import com.stackroute.muzixApp.muzix.Muzix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import com.stackroute.muzixApp.muzixRepository.MuzixRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerimpl implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${trackId1:0}")
    private int trackId;
    private String trackName;
    private String trackComments;

    @Autowired
    private Environment environment;

    @Autowired
    MuzixRepository muzixRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {


        Muzix muzix1= new Muzix(1,"abc","action");
        System.out.println("in applicationListener");
        muzixRepository.save(muzix1);
        trackName=environment.getProperty("trackName1");
        trackComments=environment.getProperty("trackComments1");
        Muzix muzix2=new Muzix(trackId,trackName,trackComments);
        muzixRepository.save(muzix2);

    }
}
