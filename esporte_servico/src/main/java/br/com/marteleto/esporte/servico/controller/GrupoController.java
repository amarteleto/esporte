package br.com.marteleto.esporte.servico.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.marteleto.esporte.core.model.GrupoModel;
import br.com.marteleto.esporte.servico.controller.interfaces.IGrupoController;
import br.com.marteleto.esporte.servico.ds.GrupoDS;
import br.com.marteleto.esporte.servico.repository.interfaces.IGrupoRepository;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-09T10:18:31.039Z[GMT]")

@Controller
public class GrupoController implements IGrupoController {
    @Autowired private IGrupoRepository grupoRepository;

    //private final ObjectMapper objectMapper;
    //private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GrupoController(ObjectMapper objectMapper, HttpServletRequest request) {
        //this.objectMapper = objectMapper;
        //this.request = request;
    }

    public ResponseEntity<GrupoDS> atualizarGrupo(@ApiParam(value = "Objeto utilizado para tranferência de dados." ,required=true )  @Valid @RequestBody GrupoDS ds) {
        //String accept = request.getHeader("Accept");
    	if (grupoRepository.existsById(ds.getId())) {
    		GrupoModel model = ds.getModel();
            grupoRepository.save(model);
            return new ResponseEntity<GrupoDS>(new GrupoDS(model), HttpStatus.OK);	
    	}
    	return new ResponseEntity<GrupoDS>(HttpStatus.NOT_FOUND);
    }
    
    public ResponseEntity<List<GrupoDS>> buscarGrupos() {
        //String accept = request.getHeader("Accept");
    	List<GrupoDS> lista = new ArrayList<>();
    	for (GrupoModel model : grupoRepository.findAll()) {
    		lista.add(new GrupoDS(model));
    	}
        return new ResponseEntity<List<GrupoDS>>(lista, HttpStatus.OK);
    }
    
    public ResponseEntity<Void> excluirGrupo(@ApiParam(value = "Id do grupo a ser excluído.",required=true) @PathVariable("id") Long id) {
        //String accept = request.getHeader("Accept");
    	grupoRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<GrupoDS> incluirGrupo(@ApiParam(value = "Objeto utilizado para tranferência de dados." ,required=true )  @Valid @RequestBody GrupoDS ds) {
        //String accept = request.getHeader("Accept");
    	GrupoModel model = ds.getModel();
        grupoRepository.save(model);
        return new ResponseEntity<GrupoDS>(new GrupoDS(model), HttpStatus.CREATED);
    }

    public ResponseEntity<GrupoDS> recuperarGrupoPorId(@ApiParam(value = "ID do grupo.",required=true) @PathVariable("id") Long id) {
        //String accept = request.getHeader("Accept");
        Optional<GrupoModel> optional = grupoRepository.findById(id);
        if (optional != null) {
        	return new ResponseEntity<GrupoDS>(new GrupoDS(optional.get()), HttpStatus.OK);
        }
        return new ResponseEntity<GrupoDS>(HttpStatus.NOT_FOUND);
    }

}
