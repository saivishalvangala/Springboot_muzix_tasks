package com.stackroute.muzixApp.seedData;

import com.stackroute.muzixApp.muzix.Muzix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import com.stackroute.muzixApp.muzixRepository.MuzixRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerimpl implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    MuzixRepository muzixRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Muzix muzix1= new Muzix(1,"abc","action");
        System.out.println("in applicationListener");
        muzixRepository.save(muzix1);
    }
}
