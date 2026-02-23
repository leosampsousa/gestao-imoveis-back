package com.rentmanager.rent_manager.repository;

import com.rentmanager.rent_manager.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
