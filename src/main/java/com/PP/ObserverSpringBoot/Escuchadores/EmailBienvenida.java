package com.PP.ObserverSpringBoot.Escuchadores;

import com.PP.ObserverSpringBoot.Eventos.UsuarioRegistradorEventos;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailBienvenida {

    @EventListener // Anotación clave para indicar que este método escucha eventos
    public void handleUserRegisteredEvent(UsuarioRegistradorEventos event) {
        System.out.println("WelcomeEmailSender: Enviando email de bienvenida a " + event.getEmail() + " para el usuario " + event.getUsername());
        // Lógica para enviar el email
    }
}
