package com.muestra.crud.controller;

import com.muestra.crud.dto.CampusDTO;
import com.muestra.crud.model.Campus;
import com.muestra.crud.service.ICampusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/campus")
public class CampusController {

    @Autowired
    private ICampusService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CampusDTO>> readAll() throws Exception {
        List<CampusDTO> lst = service.readAll().stream().map(cam -> mapper.map(cam, CampusDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampusDTO> readByID(@PathVariable("id") Integer id) throws Exception {
        CampusDTO obj = mapper.map(service.readById(id), CampusDTO.class);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CampusDTO> create(@Valid @RequestBody CampusDTO dto) throws Exception {
        Campus obj = service.save(mapper.map(dto, Campus.class));
        return new ResponseEntity<>(mapper.map(obj, CampusDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CampusDTO> update(@Valid @RequestBody CampusDTO dto) throws Exception {
        Campus obj = service.update(mapper.map(dto, Campus.class));
        return new ResponseEntity<>(mapper.map(obj, CampusDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
