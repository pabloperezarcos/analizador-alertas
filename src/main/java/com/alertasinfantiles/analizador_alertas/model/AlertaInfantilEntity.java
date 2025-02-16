package com.alertasinfantiles.analizador_alertas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ALERTAS_INFANTILES")
@Getter
@Setter
@NoArgsConstructor
public class AlertaInfantilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALERTA")
    private Long id;

    @Column(name = "NOMBRE_PACIENTE", nullable = false)
    private String nombrePaciente;

    @Column(name = "TIPO_ALERTA", nullable = false)
    private String tipoAlerta;

    @Column(name = "NIVEL_ALERTA", nullable = false)
    private String nivelAlerta;

    @Column(name = "FECHA_ALERTA", nullable = false)
    private LocalDateTime fechaAlerta;
}
