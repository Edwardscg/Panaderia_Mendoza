package com.mendozabakery.bakeryappbackend.controller;

import java.net.URI;
import java.util.List;

import com.mendozabakery.bakeryappbackend.dto.EmployeeDTO;
import com.mendozabakery.bakeryappbackend.model.Employee;
import com.mendozabakery.bakeryappbackend.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.mendozabakery.bakeryappbackend.service.IEmployeeService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmployeeController {
    private final IEmployeeService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() throws Exception {
        List<EmployeeDTO> list = service.findAll().stream()
                .map(e -> modelMapper.map(e, EmployeeDTO.class))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Integer id) throws Exception {
        Employee obj = service.findById(id);
        EmployeeDTO dto = modelMapper.map(obj, EmployeeDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody EmployeeDTO dto) throws Exception {
        Employee obj = service.save(modelMapper.map(dto, Employee.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdEmployee())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO dto, @PathVariable Integer id) throws Exception {
        Employee obj = service.update(modelMapper.map(dto, Employee.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, EmployeeDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/hateoas/{id}")
    public EntityModel<EmployeeDTO> findByIdHateoas(@PathVariable Integer id) throws Exception {
        Employee obj = service.findById(id);
        EmployeeDTO dto = modelMapper.map(obj, EmployeeDTO.class);

        EntityModel<EmployeeDTO> entityModel = EntityModel.of(dto);

        WebMvcLinkBuilder link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).findById(id));
        WebMvcLinkBuilder link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).findAll());
        WebMvcLinkBuilder link3 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).findAll());

        entityModel.add(link1.withRel("employee-self-info"));
        entityModel.add(link2.withRel("employee-all-info"));
        entityModel.add(link3.withRel("custoemr-all-info"));
        return entityModel;
    }
}
