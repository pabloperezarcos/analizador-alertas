package com.alertasinfantiles.analizador_alertas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.alertasinfantiles.analizador_alertas.model.AlertaInfantil;
import com.alertasinfantiles.analizador_alertas.model.AlertaInfantilEntity;

@Service
public class AlertaService {

    private static final String TOPIC_ALERTAS_GRAVES = "alertas_graves_infantiles";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private AlertaRepository alertaRepository;

    public void procesarAlerta(AlertaInfantil alerta) {
        if ("Alta".equalsIgnoreCase(alerta.getNivelAlerta())) {
            kafkaTemplate.send(TOPIC_ALERTAS_GRAVES, alerta);
            System.out.println("🔴 Alerta grave enviada a Kafka: " + alerta);
        } else {
            guardarAlertaEnBD(alerta);
        }
    }

    private void guardarAlertaEnBD(AlertaInfantil alerta) {
        AlertaInfantilEntity entidad = new AlertaInfantilEntity();
        entidad.setNombrePaciente(alerta.getNombrePaciente());
        entidad.setTipoAlerta(alerta.getTipoAlerta());
        entidad.setNivelAlerta(alerta.getNivelAlerta());
        entidad.setFechaAlerta(alerta.getFechaAlerta());

        alertaRepository.save(entidad);
        System.out.println("✅ Alerta almacenada en BD: " + alerta);
    }
}
