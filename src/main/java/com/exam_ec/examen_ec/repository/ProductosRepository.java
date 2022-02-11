package com.exam_ec.examen_ec.repository;

import com.exam_ec.examen_ec.entity.productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<productos,Long> {
}
