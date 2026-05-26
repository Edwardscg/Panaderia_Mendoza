package com.mendozabakery.bakeryappbackend.controller;

import java.net.URI;
import java.util.List;

import com.mendozabakery.bakeryappbackend.dto.CustomerDTO;
import com.mendozabakery.bakeryappbackend.model.Customer;
import com.mendozabakery.bakeryappbackend.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcAffordanceBuilderDsl;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.mendozabakery.bakeryappbackend.service.ICustomerService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*")
public class CustomerController {

    private final ICustomerService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() throws Exception {
        //List<Customer> list = service.findAll();
        //List<CustomerDTO> list = service.findAll().stream().map(e -> new CustomerDTO(e.getIdCustomer(), e.getNameCustomer(), e.getDni(), e.getPhone(), e.getEmail(), e.));
        //ModelMapper modelMapper = new ModelMapper();
        List<CustomerDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, CustomerDTO.class)).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Customer> findById(@PathVariable Integer id) throws Exception {
        Customer obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity <Void> save(@RequestBody CustomerDTO dto) throws Exception {
        Customer obj = service.save(modelMapper.map(dto, Customer.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCustomer()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO dto, @PathVariable Integer id) throws Exception {
        Customer obj = service.update(modelMapper.map(dto, Customer.class), id);
        return ResponseEntity.ok(modelMapper.map(obj, CustomerDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hateoas/{id}")
    public EntityModel<Customer> findByHateoas(@PathVariable Integer id) throws Exception{
        Customer obj = service.findById(id);
        EntityModel<Customer> entityModel = EntityModel.of(obj);

        WebMvcLinkBuilder link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).findById(id));
        WebMvcLinkBuilder link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).findAll());
        WebMvcLinkBuilder link3 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(SupplierController.class).findAll());

        entityModel.add(link1.withRel("customer-self-info"));
        entityModel.add(link2.withRel("customer-all-info"));
        entityModel.add(link3.withRel("supplier-all-info"));

        return entityModel;
    }
}