package com.stackroute.muzixApp.muzixRepository;

import com.stackroute.muzixApp.muzix.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface MuzixRepository extends JpaRepository<Muzix,Integer> {

    @Query("from Muzix where trackName=?1")
    public Muzix searchByName(String trackName);

}
