package br.com.marteleto.esporte.servico.controller;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.marteleto.esporte.core.model.GrupoModel;
import br.com.marteleto.esporte.servico.application.SpringBootWebApplication;
import br.com.marteleto.esporte.servico.controller.interfaces.IGrupoController;
import br.com.marteleto.esporte.servico.ds.GrupoDS;
import br.com.marteleto.esporte.servico.repository.interfaces.IGrupoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringBootWebApplication.class})
public class GrupoControllerIntegrationTest {
	@Autowired private IGrupoRepository grupoRepository;
    @Autowired private IGrupoController api;

    @Test
    public void atualizarGrupo() throws Exception {
    	GrupoModel model = grupoRepository.findAll().iterator().next();
        GrupoDS ds = new GrupoDS(model);
        ResponseEntity<GrupoDS> responseEntity = api.atualizarGrupo(ds);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    
    @Test
    public void buscarGrupos() throws Exception {
        ResponseEntity<List<GrupoDS>> responseEntity = api.buscarGrupos();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
 	
    @Test
    public void excluirGrupo() throws Exception {
    	GrupoModel model = grupoRepository.findAll().iterator().next();
        Long id = model.getId();
        ResponseEntity<Void> responseEntity = api.excluirGrupo(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void incluirGrupo() throws Exception {
        GrupoDS ds = new GrupoDS();
        ds.setNome("Grupo " + Calendar.getInstance().getTimeInMillis());
        ResponseEntity<GrupoDS> responseEntity = api.incluirGrupo(ds);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void recuperarGrupoPorId() throws Exception {
    	GrupoModel model = grupoRepository.findAll().iterator().next();
        Long id = model.getId();
        ResponseEntity<GrupoDS> responseEntity = api.recuperarGrupoPorId(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
