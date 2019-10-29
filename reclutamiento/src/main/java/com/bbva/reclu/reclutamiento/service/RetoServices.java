package com.bbva.reclu.reclutamiento.service;

import com.bbva.reclu.reclutamiento.errorhandling.InvalidRetoException;
import com.bbva.reclu.reclutamiento.model.DocumentMongo;
import com.bbva.reclu.reclutamiento.repository.RetoMongoRepository;
import com.bbva.reclu.reclutamiento.service.api.IRetoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RetoServices implements IRetoServices {

    @Autowired
    RetoMongoRepository torneoRepo;

    @Autowired
    private JavaMailSender email;

    String equipo, personaje, clase;

    @Override
    public int saveRegistro(DocumentMongo document) {
        try {
            String correo = document.getCorreo();
            if (!torneoRepo.findByCorreo(document.getCorreo()).isPresent()) {
                equipo = document.getEquipo();
                personaje = document.getPersonaje();
                clase = document.getClase();
                enviarCorreo(correo, "Registro correcto", 
                "Listo para el torneo!\nTú escogiste el equipo de "+equipo+
                ":\n- "+personaje+"\n- Clase "+clase+"\n\nBuena Suerte!");
                torneoRepo.save(document);
                return 200;
            } else {
                enviarCorreo(correo, "Registro existente", 
                "Perdon! pero su correo ya ha sido registrado\nTú escogiste el equipo de "+equipo+
                ":\n- "+personaje+"\n- Clase "+clase+"\n\n");
                return 500;
            }
        } catch (MailException e) {
            throw new InvalidRetoException("Error en el Services, desconecte su Antivirus"); //Para el local, desconecte el antivirus
        }
    }

    @Override
    public void enviarCorreo(String correo, String asunto, String texto) throws MailException{
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(correo);
        mensaje.setSubject(asunto);
        mensaje.setText(texto);
        email.send(mensaje);
    }

    /*
     * @Override public Optional<TorneoDocument> saveRegistro(TorneoDocument
     * document) { torneoRepo.save(document); return
     * torneoRepo.findById(document.getId()); }
     */

}