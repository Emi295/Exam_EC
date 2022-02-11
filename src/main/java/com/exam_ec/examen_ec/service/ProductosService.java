package com.exam_ec.examen_ec.service;

import com.exam_ec.examen_ec.entity.productos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductosService {

    public Iterable<productos> findAll();
    public Page<productos> finALL(Pageable pageable);
    public Optional<productos> findById(Long id);
    public productos save(productos user);
    public void deleteById(Long id);
}
