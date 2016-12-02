package com.example.controller;

import com.example.domain.Medal;
import com.example.repository.MedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/medals")
public class MedalController {
    @Autowired
    private MedalRepository medalRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medal createMedal(@RequestBody Medal medal){
        return medalRepository.save(medal);
    }

    @GetMapping
    public List<Medal> getAllMedals(){
        List<Medal> medals = new ArrayList<>();
        Iterator<Medal> iterator = medalRepository
                .findAll()
                .iterator();
        while(iterator.hasNext()){
            medals.add(iterator.next());
        }
        return medals;
    }

    @PutMapping
    public Medal updateMedal(@RequestBody Medal medal){
        return medalRepository.save(medal);
    }

    @DeleteMapping("/{id}")
    public void deleteMedalID(@PathVariable Long id){
        Medal medal = medalRepository.findOne(id);
        if(medal != null ) medalRepository.delete(id);
    }
}
