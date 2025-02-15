package com.analizadoralertas.analizador_alertas.service;

import com.analizadoralertas.analizador_alertas.model.AlertaInfantil;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AlertaService {

    private final KafkaTemplate<String, AlertaInfantil> kafkaTemplate;

    public AlertaService(KafkaTemplate<String, AlertaInfantil> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void procesarAlerta(AlertaInfantil alerta) {
        if ("Alta".equalsIgnoreCase(alerta.getNivelAlerta())) {
            System.out.println("🚨 Alerta CRÍTICA detectada: " + alerta);

            // Publicar en el nuevo tópico "alertas_analizadas"
            kafkaTemplate.send("alertas_analizadas", alerta);
        } else {
            System.out.println("✅ Alerta de nivel menor ignorada: " + alerta);
        }
    }
}
