package com.stackroute.muzixApp.muzixService;

import com.stackroute.muzixApp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApp.exceptions.TrackNotFoundException;
import com.stackroute.muzixApp.muzix.Muzix;
import com.stackroute.muzixApp.muzixRepository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="DummyMuzixServiceImpl")
public class DummyMuzixServiceImpl implements MuzixService{
    MuzixRepository muzixRepository;

    @Autowired
    public DummyMuzixServiceImpl(MuzixRepository muzixRepository)
    {
        this.muzixRepository=muzixRepository;
        System.out.println("iam in DummyMuzixServiceImpl class");
    }



    @Override
    public Muzix saveTrack(Muzix muzix) throws TrackAlreadyExistsException{
        if(muzixRepository.existsById(muzix.getTrackId())){
            throw new TrackAlreadyExistsException("track you are trying to save already exists");
        }
        Muzix savedMuzix=muzixRepository.save(muzix);
        return savedMuzix;
    }

    @Override
    public List<Muzix> displayTracks() {

        return muzixRepository.findAll();
    }

    @Override
    public void  deleteTrack(int id)throws  TrackNotFoundException  {

        if(!(muzixRepository.existsById(id)))
        {
            throw new TrackNotFoundException("track you are searching is not found");
        }
        else {
            muzixRepository.deleteById(id);

        }
    }

    @Override
    public Muzix search(String trackName) throws TrackNotFoundException {

//        List<Muzix> list=muzixRepository.findAll();
//        Iterator itr=list.iterator();
//        Muzix m;
//        int flag=0;
//        while(itr.hasNext()){
//            m=(Muzix)itr.next();
//            if(m.getTrackName().equals(trackName)){
//                flag=1;
//                break;
//            }
//        }
//        return flag;

        Muzix muzix=muzixRepository.searchByName(trackName);
        if(muzix==null)
        {
            throw new TrackNotFoundException("track you are searching is not found");
        }
        return muzix;

    }


}
