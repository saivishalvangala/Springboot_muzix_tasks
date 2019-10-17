package com.stackroute.muzixApp.seedData;

import com.stackroute.muzixApp.muzix.Muzix;
import com.stackroute.muzixApp.muzixRepository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    MuzixRepository muzixRepository;

    @Override
    public void run(String... args) throws Exception {
        Muzix muzix=new Muzix(2,"def","patriotic");
        System.out.println("in commandLineRunner");
        muzixRepository.save(muzix);
    }
}
