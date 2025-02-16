package com.alertasinfantiles.analizador_alertas.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.alertasinfantiles.analizador_alertas.model.AlertaInfantil;
import com.alertasinfantiles.analizador_alertas.service.AlertaService;

@Component
public class AlertaInfantilListener {

    @Autowired
    private AlertaService alertaService;

    @KafkaListener(topics = "alertas_infantiles", groupId = "grupo-analizador")
    public void escucharAlerta(AlertaInfantil alerta) {
        System.out.println("📥 Alerta recibida: " + alerta);
        alertaService.procesarAlerta(alerta);
    }
}
