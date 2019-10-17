package com.stackroute.muzixApp.muzixService;


import com.stackroute.muzixApp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApp.exceptions.TrackNotFoundException;
import com.stackroute.muzixApp.muzix.Muzix;

import java.util.List;

public interface MuzixService {
    public Muzix saveTrack(Muzix muzix)throws TrackAlreadyExistsException;

    public List<Muzix> displayTracks();

    public void deleteTrack(int id)throws TrackNotFoundException ;

    public Muzix search(String trackName)throws TrackNotFoundException;


}
