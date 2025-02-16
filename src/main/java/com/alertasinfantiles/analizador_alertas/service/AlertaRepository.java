package com.alertasinfantiles.analizador_alertas.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alertasinfantiles.analizador_alertas.model.AlertaInfantilEntity;

@Repository
public interface AlertaRepository extends JpaRepository<AlertaInfantilEntity, Long> {
}
