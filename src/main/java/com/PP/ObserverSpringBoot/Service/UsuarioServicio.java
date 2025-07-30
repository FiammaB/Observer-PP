package com.PP.ObserverSpringBoot.Service;

import com.PP.ObserverSpringBoot.Eventos.UsuarioRegistradorEventos;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    private final ApplicationEventPublisher eventPublisher;

    // Spring inyecta automáticamente ApplicationEventPublisher
    public UsuarioServicio(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void registerUser(String username, String email) {
        System.out.println("Registrando usuario: " + username + " con email: " + email);
        // Lógica de negocio para registrar el usuario (guardar en BD, etc.)

        // Publica el evento UserRegisteredEvent
        eventPublisher.publishEvent(new UsuarioRegistradorEventos(this, username, email));
        System.out.println("Evento UserRegisteredEvent publicado.");
    }
}
