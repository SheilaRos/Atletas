package com.example.domain;

import javax.persistence.*;


@Entity
public class Medal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    private MedalType medalType;
    private String speciality;
    private String competition;
    @ManyToOne
    private Athlete athlete;

    public Medal() {
    }

    public Medal(MedalType medalType, String speciality, String competition) {
        this.medalType = medalType;
        this.speciality = speciality;
        this.competition = competition;
    }
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public MedalType getMedalType() {return medalType;}
    public void setMedalType(MedalType medalType) {this.medalType = medalType;}
    public String getSpeciality() {return speciality;}
    public void setSpeciality(String speciality) {this.speciality = speciality;}
    public String getCompetition() {return competition;}
    public void setCompetition(String competition) {this.competition = competition;}
    public Athlete getAthlete() {return athlete;}
    public void setAthlete(Athlete athlete) {this.athlete = athlete;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medal medal = (Medal) o;

        if (id != medal.id) return false;
        if (medalType != medal.medalType) return false;
        if (speciality != null ? !speciality.equals(medal.speciality) : medal.speciality != null) return false;
        if (competition != null ? !competition.equals(medal.competition) : medal.competition != null) return false;
        return athlete != null ? athlete.equals(medal.athlete) : medal.athlete == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (medalType != null ? medalType.hashCode() : 0);
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        result = 31 * result + (competition != null ? competition.hashCode() : 0);
        result = 31 * result + (athlete != null ? athlete.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Medal{" +
                "id=" + id +
                ", medalType=" + medalType +
                ", speciality='" + speciality + '\'' +
                ", competition='" + competition + '\'' +
                ", athlete=" + athlete +
                '}';
    }
}
