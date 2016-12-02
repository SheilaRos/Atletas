package com.example.service;

import com.example.domain.Medal;
import com.example.domain.MedalType;
import com.example.repository.AthleteRepository;
import com.example.repository.MedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedalService {
    @Autowired
    private MedalRepository medalRepository;
    @Autowired
    private AthleteRepository athleteRepository;

    public void createMedal(){
        Medal medal1 = new Medal(MedalType.GOLD, "Tiro con arco", "JJOO 2016");
        medal1.setAthlete(athleteRepository.findByNameIs("Clint"));
        medalRepository.save(medal1);
        Medal medal2= new Medal(MedalType.GOLD, "Lanzamiento de martillo", "Asgard Competition");
        medal2.setAthlete(athleteRepository.findByNameIs("Thor"));
        medalRepository.save(medal2);
        Medal medal3 = new Medal(MedalType.SILVER, "Tiro con arco", "JJOO 2016");
        medal3.setAthlete(athleteRepository.findByNameIs("Wanda"));
        medalRepository.save(medal3);
        Medal medal4 = new Medal(MedalType.SILVER, "Lanzamiento de martillo", "Asgard Competition");
        medal4.setAthlete(athleteRepository.findByNameIs("Natasha"));
        medalRepository.save(medal4);
        Medal medal5 = new Medal(MedalType.BRONCE, "Tiro con arco", "JJOO 2016");
        medal5.setAthlete(athleteRepository.findByNameIs("Natasha"));
        medalRepository.save(medal5);
        Medal medal6 = new Medal(MedalType.BRONCE, "Lanzamiento de martillo", "Asgard Competition");
        medal6.setAthlete(athleteRepository.findByNameIs("Clint"));
        medalRepository.save(medal6);
        Medal medal7 = new Medal(MedalType.GOLD, "Levantamiento de peso", "JJOO 2016");
        medal7.setAthlete(athleteRepository.findByNameIs("Bruce"));
        medalRepository.save(medal7);
        Medal medal8 = new Medal(MedalType.SILVER, "Levantamiento de peso", "JJOO 2016");
        medal8.setAthlete(athleteRepository.findByNameIs("Tony"));
        medalRepository.save(medal8);
        Medal medal9 = new Medal(MedalType.BRONCE, "Levantamiento de peso", "JJOO 2016");
        medal9.setAthlete(athleteRepository.findByNameIs("Steve"));
        medalRepository.save(medal9);
    }
    public void testMedal(){

    }
}
