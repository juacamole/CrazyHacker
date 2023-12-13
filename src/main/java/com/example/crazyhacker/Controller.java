package com.example.crazyhacker;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Controller {
    private final DataService service;

    @PostMapping("/api/todo")
    public List<Data> postAllData(@RequestBody Data data){
        return service.postData(data);
    }
    @GetMapping("/api/todo")
    public List<Data> getAllData(){
        return service.findAll();
    }
    @GetMapping("/api/todo/{id}")
    public Optional<Data> getDataById(@PathVariable String id){
        return service.findById(id);
    }
    @PutMapping("/api/todo/{id}")
    public Optional<Data> updateById(@PathVariable String id,@RequestBody Data data){
        return service.updateById(id, data);
    }
    @DeleteMapping("api/todo/{id}")
    public void DeleteDataById(@PathVariable String id) {
        service.DeleteById(id);

    }
}

