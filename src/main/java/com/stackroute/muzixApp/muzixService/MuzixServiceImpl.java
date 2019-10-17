package com.stackroute.muzixApp.muzixService;

import com.stackroute.muzixApp.muzix.Muzix;
import com.stackroute.muzixApp.muzixRepository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class MuzixServiceImpl implements MuzixService {

    MuzixRepository muzixRepository;

    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository)
    {
        this.muzixRepository=muzixRepository;
    }



    @Override
    public Muzix saveTrack(Muzix muzix) {
        Muzix savedMuzix=muzixRepository.save(muzix);
        return savedMuzix;
    }

    @Override
    public List<Muzix> displayTracks() {

        return muzixRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int id) {
        Muzix muzix=muzixRepository.getOne(id);
        if(muzix==null)
        {
            return false;
        }
        else {
            muzixRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public Muzix search(String trackName) {

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
        return muzix;

    }


}
