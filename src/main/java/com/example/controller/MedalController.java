package com.example.controller;

import com.example.domain.Medal;
import com.example.repository.MedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        return medalRepository.findAll();
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
