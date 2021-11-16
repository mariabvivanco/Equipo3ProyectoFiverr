package com.example.Equipo3ProyectoFiverr.Services;

import com.example.Equipo3ProyectoFiverr.entities.Empleadores;

import java.util.Random;

public class ServiceImages {

    public String randomURLGenerator(String categoryName) {
        String id = generateRandomId();
        String url = "https://source.unsplash.com/featured/" +
                "?" + categoryName +
                "/600x300/" + id;

        return url;
    }

    //Genera un ID random para la foto
    protected String generateRandomId(){
        Random random = new Random();
        int randomNumber = random.nextInt((9999 - 1) + 1);
        String intString = Integer.toString(randomNumber);
        return intString;
    }
}
