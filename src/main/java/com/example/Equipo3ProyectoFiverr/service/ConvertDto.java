package com.example.Equipo3ProyectoFiverr.service;

import com.example.Equipo3ProyectoFiverr.dto.JobDto;
import com.example.Equipo3ProyectoFiverr.entities.Job;
import com.example.Equipo3ProyectoFiverr.entities.Opinion;
import java.util.List;
import java.util.Set;

public interface ConvertDto {
    List<JobDto> convertJobForCategory(List<Opinion> opinions, Set<Job> jobs);
    List<JobDto> convertAllJob(List<Opinion> opinions, List<Job> jobs);
}
