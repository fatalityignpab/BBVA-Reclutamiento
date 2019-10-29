package com.bbva.reclu.reclutamiento.controller;

import com.bbva.reclu.reclutamiento.model.DocumentMongo;
import com.bbva.reclu.reclutamiento.service.api.IRetoServices;

/* import java.util.Optional; */

//import com.upiicsa.torneoservices.errorhandling.InvalidTorneoException;
import com.bbva.reclu.reclutamiento.model.ResponseCode;

import org.springframework.beans.factory.annotation.Autowired;
/* import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; */
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TorneoController {
    @Autowired
    IRetoServices torneoService;

    @PostMapping(path = "/registro", consumes = "application/json", produces = "application/json")
    public ResponseCode registrar(@RequestBody DocumentMongo document) {
        if (torneoService.saveRegistro(document) == 200) {
            return new ResponseCode(200, "Registro");
        } else {
            return new ResponseCode(500, "Correo Existente");
        }
    }
}