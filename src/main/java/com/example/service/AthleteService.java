package com.example.service;

import com.example.domain.Athlete;
import com.example.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class AthleteService {
    @Autowired
    private AthleteRepository athleteRepository;

    public void createAthlete(){
        Athlete athlete1 = new Athlete("Thor", "Odinson", "Asgardiano", LocalDate.of(1962, 8, 1));
        athleteRepository.save(athlete1);
        Athlete athlete2 = new Athlete("Tony", "Stark", "Estadounidense", LocalDate.of( 1963, 3, 1));
        athleteRepository.save(athlete2);
        Athlete athlete3 = new Athlete("Steve", "Rogers", "Estadounidense", LocalDate.of( 1941, 3, 1));
        athleteRepository.save(athlete3);
        Athlete athlete4 = new Athlete("Clint", "Barton", "Canadiense", LocalDate.of(1965,5,1));
        athleteRepository.save(athlete4);
        Athlete athlete5 = new Athlete("Natasha", "Romanoff", "Rusa", LocalDate.of( 1964, 4, 1));
        athleteRepository.save(athlete5);
        Athlete athlete6 = new Athlete("Bruce", "Banner", "Estadounidense", LocalDate.of( 1962, 5, 1));
        athleteRepository.save(athlete6);
        Athlete athlete7 = new Athlete("Henry", "Pym", "Estadounidense", LocalDate.of( 1962, 1, 1));
        athleteRepository.save(athlete7);
        Athlete athlete8 = new Athlete("Janet", "Van Dyne", "Estadounidense", LocalDate.of( 1963, 6, 1));
        athleteRepository.save(athlete8);
        Athlete athlete9 = new Athlete("T'Challa", "Chaka", "Wakandes", LocalDate.of( 1966, 10, 1));
        athleteRepository.save(athlete9);
        Athlete athlete10 = new Athlete("Pietro", "Maximoff", "Rusa", LocalDate.of( 1964, 5, 1));
        athleteRepository.save(athlete10);
        Athlete athlete11 = new Athlete("Wanda", "Maximoff", "Rusa", LocalDate.of( 1964, 5, 1));
        athleteRepository.save(athlete11);
        Athlete athlete12 = new Athlete("Monica", "Rambeau", "Estadounidense", LocalDate.of( 1982, 6, 1));
        athleteRepository.save(athlete12);
        Athlete athlete13 = new Athlete("Wade", "Winston Wilson", "Estadounidense", LocalDate.of( 1991, 2, 1));
        athleteRepository.save(athlete13);

    }
    public void testAthlete(){
        System.out.println(athleteRepository.findByNacionalityIs("Rusa"));
        System.out.println(athleteRepository.findByBirthdayBefore(LocalDate.of(1962, 12, 1)));
    }
}
