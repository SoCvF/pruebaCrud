package com.muestra.crud.controller;

import com.muestra.crud.dto.StudentsDTO;
import com.muestra.crud.model.Students;
import com.muestra.crud.service.IStudentsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private IStudentsService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<StudentsDTO>> readAll() throws Exception {
        List<StudentsDTO> lst = service.readAll().stream().map(stts -> mapper.map(stts, StudentsDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentsDTO> readByID(@PathVariable("id") Integer id) throws Exception {
        StudentsDTO obj = mapper.map(service.readById(id), StudentsDTO.class);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentsDTO> create(@Valid @RequestBody StudentsDTO dto) throws Exception {
        Students obj = service.save(mapper.map(dto, Students.class));
        return new ResponseEntity<>(mapper.map(obj, StudentsDTO.class), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StudentsDTO> update(@Valid @RequestBody StudentsDTO dto) throws Exception {
        Students obj = service.update(mapper.map(dto, Students.class));
        return new ResponseEntity<>(mapper.map(obj, StudentsDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
