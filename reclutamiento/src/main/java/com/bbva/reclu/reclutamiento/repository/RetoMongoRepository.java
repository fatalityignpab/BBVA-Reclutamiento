package com.bbva.reclu.reclutamiento.repository;

import java.util.Optional;

import com.bbva.reclu.reclutamiento.model.DocumentMongo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RetoMongoRepository extends CrudRepository<DocumentMongo, String>{

    Optional<DocumentMongo> findByCorreo(String Correo);
}