package com.alertasinfantiles.analizador_alertas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data // Genera get y set automaticamente gracias a Lombok
@AllArgsConstructor // Crea constructor automatico
@NoArgsConstructor // Crea constructor automatico
public class AlertaInfantil {
    private String nombrePaciente;
    private String tipoAlerta;
    private String nivelAlerta;
    private LocalDateTime fechaAlerta;
}
