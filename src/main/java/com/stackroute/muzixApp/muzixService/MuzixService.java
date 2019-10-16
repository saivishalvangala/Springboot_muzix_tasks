package com.stackroute.muzixApp.muzixService;


import com.stackroute.muzixApp.muzix.Muzix;

import java.util.List;

public interface MuzixService {
    public Muzix saveTrack(Muzix muzix);

    public List<Muzix> displayTracks();

    public boolean deleteTrack(int id);


}
