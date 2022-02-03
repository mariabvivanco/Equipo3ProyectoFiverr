package com.example.Equipo3ProyectoFiverr.entities;


import javax.persistence.*;

@Entity
@Table(name = "opinion")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column()
    private int qualification;

    private String description;

    @ManyToOne
    private Job job;

    @ManyToOne
    private Employer employer;

    public Opinion() {
    }

    public Opinion(Long id, int qualification, String description, Job job, Employer employer) {
        this.id = id;
        this.qualification = qualification;
        this.description = description;
        this.job = job;
        this.employer = employer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
