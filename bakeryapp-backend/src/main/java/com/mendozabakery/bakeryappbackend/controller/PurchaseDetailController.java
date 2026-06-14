package com.mendozabakery.bakeryappbackend.controller;

import com.mendozabakery.bakeryappbackend.dto.PurchaseDetailDTO;
import com.mendozabakery.bakeryappbackend.model.PurchaseDetail;
import com.mendozabakery.bakeryappbackend.service.IPurchaseDetailService;
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
@RequestMapping("/purchase-details")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class PurchaseDetailController {

    private final IPurchaseDetailService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PurchaseDetailDTO>> findAll() throws Exception {

        List<PurchaseDetailDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, PurchaseDetailDTO.class)).toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDetail> findById(@PathVariable Integer id) throws Exception {

        PurchaseDetail obj = service.findById(id);

        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PurchaseDetailDTO dto) throws Exception {

        PurchaseDetail obj = service.save(modelMapper.map(dto, PurchaseDetail.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPurchaseDetail()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseDetailDTO> update(@RequestBody PurchaseDetailDTO dto, @PathVariable Integer id) throws Exception {

        PurchaseDetail obj = service.update(modelMapper.map(dto, PurchaseDetail.class), id);

        return ResponseEntity.ok(modelMapper.map(obj, PurchaseDetailDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}