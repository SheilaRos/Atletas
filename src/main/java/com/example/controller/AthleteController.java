package com.example.controller;

import com.example.domain.Athlete;
import com.example.domain.MedalType;
import com.example.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;


@RestController
@RequestMapping("/athletes")
public class AthleteController {
    @Autowired
    private AthleteRepository athleteRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Athlete createAthlete(@RequestBody Athlete athlete){
        return athleteRepository.save(athlete);
    }

    @GetMapping
    public List<Athlete> getAllAthletes(){
        List<Athlete> athletes = new ArrayList<>();
        Iterator<Athlete> iterator = athleteRepository
                .findAll()
                .iterator();
        while(iterator.hasNext()){
            athletes.add(iterator.next());
        }
        return athletes;
    }

    @PutMapping
    public Athlete updateAthlete(@RequestBody Athlete athlete){
        return athleteRepository.save(athlete);
    }

    @DeleteMapping("/{id}")
    public void deleteAthleteID(@PathVariable Long id){
        Athlete athlete = athleteRepository.findOne(id);
        if(athlete != null ) athleteRepository.delete(id);
    }


    @GetMapping("/GroupByNacionality")
    public Map<String, List<Athlete>> getAthleteGroupByNacionality(){
        return athleteRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(Athlete::getNacionality));
    }

    @GetMapping("/GroupByMedalType")
    public Map<MedalType, List<Athlete>> getAthleteGroupByMedalType(){
        //Buscas todos los atletas
        //Los preparas para el procesamiento en paralelo
        //Con la clase collect agrupas los atletas mediante un lambda
        //Al lambda le pasas un atleta
        //entonces con estas dos lineas en la clase Athlete :
        // "@OneToMany(mappedBy = "athlete")" que indica la relación 1 medalla para muchos, y dice que esta mapeado por el atributo "athlete" de la clase Medal y
        //"private List<Medal> medals;"  atributo que guarda todas las medallas de un athleta;
        //Obtenemos las medallas que tiene este athleta, las procesamos y si en el "anyMatch" (En el cual tenemos un lambda de medalla, donde le pasamos una medalla
        // y la compara con el tipo GOLD, SILVER, BRONCE o NONE(tipo que creamos para que si un atleta no tiene ninguna medalla, no dé un error
        // al crear el JSON) y devuelve true o false) devuelve true, se guardara en la agrupación correspondiente (en este if sería la de GOLD)

        return athleteRepository
                .findAll()
                .parallelStream()
                .collect(groupingBy(athlete -> {
                    if(athlete.getMedals().stream().anyMatch(medal -> medal.getMedalType() == MedalType.GOLD)){
                        return MedalType.GOLD;
                    }else if(athlete.getMedals().stream().anyMatch(medal -> medal.getMedalType() == MedalType.SILVER)){
                        return MedalType.SILVER;
                    }else if(athlete.getMedals().stream().anyMatch(medal -> medal.getMedalType() == MedalType.BRONCE)){
                        return MedalType.BRONCE;
                    }else {
                        return MedalType.NONE;
                    }
                }));
    }



}
