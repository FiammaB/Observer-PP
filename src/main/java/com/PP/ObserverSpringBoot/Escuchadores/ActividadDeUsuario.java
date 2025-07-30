package com.PP.ObserverSpringBoot.Escuchadores;

import com.PP.ObserverSpringBoot.Eventos.UsuarioRegistradorEventos;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ActividadDeUsuario {
    @EventListener
    public void handleUserRegisteredEvent(UsuarioRegistradorEventos event) {
        System.out.println("UserActivityLogger: Registrando actividad para el usuario " + event.getUsername() + " - Evento: " + event.getClass().getSimpleName());
        // Lógica para registrar la actividad
    }
}
