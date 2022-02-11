package com.exam_ec.examen_ec.service;

import com.exam_ec.examen_ec.entity.productos;
import com.exam_ec.examen_ec.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<productos> findAll() {
        return productosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<productos> finALL(Pageable pageable) {
        return productosRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<productos> findById(Long id) {
        return productosRepository.findById(id);
    }

    @Override
    @Transactional
    public productos save(productos prod) {
        return productosRepository.save(prod);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productosRepository.deleteById(id);
    }
}
