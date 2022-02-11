package com.exam_ec.examen_ec.controller;

import com.exam_ec.examen_ec.entity.productos;
import com.exam_ec.examen_ec.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/product")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @PostMapping
    public ResponseEntity<?> create (@RequestBody productos prod){
        return ResponseEntity.status(HttpStatus.CREATED).body(productosService.save(prod));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long prodId){
        Optional<productos> optional=productosService.findById(prodId);

        if (!optional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody  productos userDetails, @PathVariable Long id){
        Optional<productos> prod = productosService.findById(id);

        if (!prod.isPresent()){
            return ResponseEntity.notFound().build();
        }
        prod.get().setDescripcion(userDetails.getDescripcion());
        prod.get().setCantidad(userDetails.getCantidad());
        prod.get().setPrecio(userDetails.getPrecio());

        return ResponseEntity.status(HttpStatus.CREATED).body(productosService.save(prod.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        if(!productosService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        productosService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<productos> readAll(){
        List<productos> produc = StreamSupport
                .stream(productosService.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return produc;
    }
}
