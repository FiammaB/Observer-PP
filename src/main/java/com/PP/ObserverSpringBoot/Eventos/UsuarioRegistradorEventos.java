package com.PP.ObserverSpringBoot.Eventos;

import org.springframework.context.ApplicationEvent;

public class UsuarioRegistradorEventos extends ApplicationEvent {

    private String username;
    private String email;

    public UsuarioRegistradorEventos(Object source, String username, String email) {
        super(source); // 'source' es el objeto que originó el evento
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserRegisteredEvent{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}