package com.stackroute.muzixApp.muzixRepository;

import com.stackroute.muzixApp.muzix.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuzixRepository extends JpaRepository<Muzix,Integer> {

}
