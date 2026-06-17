package com.mendozabakery.bakeryappbackend.controller;

import com.mendozabakery.bakeryappbackend.dto.SaleDetailDTO;
import com.mendozabakery.bakeryappbackend.model.SaleDetail;
import com.mendozabakery.bakeryappbackend.service.ISaleDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sale-details")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class SaleDetailController {

    private final ISaleDetailService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<SaleDetailDTO>> findAll() throws Exception {

        List<SaleDetailDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, SaleDetailDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDetail> findById(@PathVariable Integer id) throws Exception {

        SaleDetail obj = service.findById(id);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SaleDetailDTO dto) throws Exception {

        SaleDetail obj = service.save(modelMapper.map(dto, SaleDetail.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSaleDetail()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDetailDTO> update(@RequestBody SaleDetailDTO dto, @PathVariable Integer id) throws Exception {

        SaleDetail obj = service.update(modelMapper.map(dto, SaleDetail.class), id);

        return ResponseEntity.ok(modelMapper.map(obj, SaleDetailDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}