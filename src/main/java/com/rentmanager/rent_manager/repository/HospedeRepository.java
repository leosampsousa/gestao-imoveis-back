package com.rentmanager.rent_manager.repository;

import com.rentmanager.rent_manager.entity.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long>, JpaSpecificationExecutor<Hospede> {
    Optional<Hospede> findByDocumento(String documento);
}
