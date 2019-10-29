package com.bbva.reclu.reclutamiento.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "reto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DocumentMongo {

    @Id
    String id;

    @Field("plataforma")
    String plataforma;

    @Field("genero")
    String genero;
    
    @Field("edad")
    String edad;
    
    @Field("correo")
    String correo;
    
    @Field("equipo")
    String equipo;
    
    @Field("personaje")
    String personaje;
    
    @Field("clase")
    String clase;
    
}