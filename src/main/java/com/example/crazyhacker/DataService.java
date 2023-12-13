package com.example.crazyhacker;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DataService {

    private final DataRepository repo;

    public DataService(DataRepository repo) {
        this.repo = repo;
    }

    public List<Data> findAll(){
        return repo.findAll();
    }
    public List<Data> postData(Data data){
        Data toSave = new Data(data.description(), data.status(), UUID.randomUUID().toString());
        return Collections.singletonList(repo.save(toSave));
    }

    public Optional<Data> findById(String id) {
        return repo.findById(id);
    }

    public Optional<Data> updateById(String id, Data data) {
        repo.deleteById(id);
        Data toUpdate = new Data(data.description(), data.status(), id);
       return Optional.of(repo.save(toUpdate));
    }

    public void DeleteById(String id) {
         repo.deleteById(id);
    }
}
