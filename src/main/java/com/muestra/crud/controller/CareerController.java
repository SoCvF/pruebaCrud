package com.muestra.crud.controller;

import com.muestra.crud.dto.CareerDTO;
import com.muestra.crud.model.Career;
import com.muestra.crud.service.ICareerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/career")
public class CareerController {

    @Autowired
    private ICareerService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CareerDTO>> readAll() throws Exception {
        List<CareerDTO> lst = service.readAll().stream().map(care -> mapper.map(care, CareerDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CareerDTO> readByID(@PathVariable("id") Integer id) throws Exception {
        CareerDTO obj = mapper.map(service.readById(id), CareerDTO.class);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CareerDTO> create(@Valid @RequestBody CareerDTO dto) throws Exception {
        Career obj = service.save(mapper.map(dto, Career.class));
        return new ResponseEntity<>(mapper.map(obj, CareerDTO.class), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CareerDTO> update(@Valid @RequestBody CareerDTO dto) throws Exception {
        Career obj = service.update(mapper.map(dto, Career.class));
        return new ResponseEntity<>(mapper.map(obj, CareerDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
