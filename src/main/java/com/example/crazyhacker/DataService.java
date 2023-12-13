package com.example.crazyhacker;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DataService {

    private final DataRepository repo;
    private final TempRepository tepo;

    public DataService(DataRepository repo, TempRepository tepo) {
        this.repo = repo;
        this.tepo = tepo;
    }

    public List<Data> findAll(){
        return repo.findAll();
    }
    public List<Data> postData(Data data){
        Data toSave = new Data(data.description(), data.status(), UUID.randomUUID().toString());
        tepo.save(null);
        return Collections.singletonList(repo.save(toSave));
    }

    public Optional<Data> findById(String id) {
        return repo.findById(id);
    }

    public Optional<Data> updateById(String id, Data data) {

        repo.deleteById(id);
        Data toUpdate = new Data(data.description(), data.status(), id);
        tepo.save();
        return Optional.of(repo.save(toUpdate));
    }

    public void DeleteById(String id) {
        Optional<Data> tosave = repo.findById(id);
        TempData tempSave = new TempData(tosave.get().description(),tosave.get().status(), id);
        tepo.save(tempSave);
        repo.deleteById(id);
    }
}
