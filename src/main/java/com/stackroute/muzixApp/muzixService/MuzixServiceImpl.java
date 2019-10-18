package com.stackroute.muzixApp.muzixService;

import com.stackroute.muzixApp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApp.exceptions.TrackNotFoundException;
import com.stackroute.muzixApp.muzix.Muzix;
import com.stackroute.muzixApp.muzixRepository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service(value="MuzixServiceImpl")
@Primary
public class MuzixServiceImpl implements MuzixService {

    private MuzixRepository muzixRepository;

    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository)
    {
        this.muzixRepository=muzixRepository;
        System.out.println("iam in MuzixServiceImpl class");
    }



    @Override
    public Muzix saveTrack(Muzix muzix) throws TrackAlreadyExistsException,Exception{
        if(muzixRepository.existsById(muzix.getTrackId())){
            throw new TrackAlreadyExistsException("track you are trying to save already exists");
        }
        Muzix savedMuzix=muzixRepository.save(muzix);
        return savedMuzix;
    }

    @Override
    public List<Muzix> displayTracks() throws TrackNotFoundException,Exception {

        List<Muzix> list= muzixRepository.findAll();
        if(list.size()==0){
            throw new TrackNotFoundException("No tracks are available in database");
        }
        return list;
    }

    @Override
    public Muzix deleteTrack(int id)throws  TrackNotFoundException,Exception  {

        Muzix muzix;
        if(!(muzixRepository.existsById(id)))
        {
            throw new TrackNotFoundException("track you are searching is not found");
        }
        else {
            muzix=muzixRepository.getOne(id);
            muzixRepository.deleteById(id);

        }
        return muzix;
    }

    @Override
    public Muzix search(String trackName) throws TrackNotFoundException,Exception {

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
