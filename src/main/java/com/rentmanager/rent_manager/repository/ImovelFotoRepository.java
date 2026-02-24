package com.rentmanager.rent_manager.repository;

import com.rentmanager.rent_manager.entity.ImovelFoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImovelFotoRepository extends JpaRepository<ImovelFoto, Long>, JpaSpecificationExecutor<ImovelFoto> {
}
