package com.analizadoralertas.analizador_alertas.kafka;

import com.analizadoralertas.analizador_alertas.model.AlertaInfantil;
import com.analizadoralertas.analizador_alertas.service.AlertaService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AlertaInfantilListener {

    private final AlertaService alertaService;

    public AlertaInfantilListener(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @KafkaListener(topics = "alertas_infantiles", groupId = "grupo-analizador", containerFactory = "alertaKafkaListenerContainerFactory")
    public void recibirAlerta(AlertaInfantil alerta) {
        System.out.println("🔔 Nueva alerta infantil recibida: " + alerta);

        // Procesar alerta según su nivel
        alertaService.procesarAlerta(alerta);
    }
}
