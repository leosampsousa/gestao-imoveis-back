package com.rentmanager.rent_manager.repository;

import com.rentmanager.rent_manager.entity.ImovelFoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelFotoRepository extends JpaRepository<ImovelFoto, Long>, JpaSpecificationExecutor<ImovelFoto> {
}
