package com.bbva.reclu.reclutamiento.service.api;

import com.bbva.reclu.reclutamiento.model.DocumentMongo;

import org.springframework.mail.MailException;

public interface IRetoServices {

    int saveRegistro(DocumentMongo document);
    void enviarCorreo(String correo, String asunto, String texto) throws MailException;
    
}