package com.example.Equipo3ProyectoFiverr.service;

import com.example.Equipo3ProyectoFiverr.dto.JobDto;
import com.example.Equipo3ProyectoFiverr.entities.Job;
import com.example.Equipo3ProyectoFiverr.entities.Opinion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ConvertDtoImpl implements ConvertDto{
    @Override
    public List<JobDto> convertJobForCategory(List<Opinion> opinions, Set<Job> jobs){

        List<JobDto> jobsDto =new ArrayList<>();

        for (Job job: jobs) {
            JobDto jobDto = new JobDto(job.getId(), job.getName(), job.getImage(),
                    job.getDescription(), job.getCategories(), job.getEmployers(),
                    job.getDate(), job.getPrice());
            int sumOpinions = 0, cantOpinions = 0;
            double ave = 0;
            for (int i = 0; i < opinions.size(); i++) {
                if (opinions.get(i).getJob() == job) {
                    cantOpinions++;
                    sumOpinions = sumOpinions + opinions.get(i).getQualification();
                }
            }
            if (cantOpinions > 0) {
                jobDto.setOpinions(cantOpinions);
                ave = sumOpinions / cantOpinions;
                jobDto.setAve(ave);
            }
            jobsDto.add(jobDto);
        }
       return jobsDto;

    }

    @Override
    public List<JobDto> convertAllJob(List<Opinion> opinions, List<Job> jobs){

        List<JobDto> jobsDto =new ArrayList<>();

        for (Job job: jobs) {
            JobDto jobDto = new JobDto(job.getId(), job.getName(), job.getImage(),
                    job.getDescription(), job.getCategories(), job.getEmployers(),
                    job.getDate(), job.getPrice());
            int sumOpinions = 0, cantOpinions = 0;
            double ave = 0;
            for (int i = 0; i < opinions.size(); i++) {
                if (opinions.get(i).getJob() == job) {
                    cantOpinions++;
                    sumOpinions = sumOpinions + opinions.get(i).getQualification();
                }
            }
            if (cantOpinions > 0) {
                jobDto.setOpinions(cantOpinions);
                ave = sumOpinions / cantOpinions;
                jobDto.setAve(ave);
            }
            jobsDto.add(jobDto);
        }
        return jobsDto;

    }
}
