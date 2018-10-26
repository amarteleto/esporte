package br.com.marteleto.esporte.servico.repository.interfaces;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import br.com.marteleto.esporte.core.model.GrupoModel;

public interface IGrupoRepository extends CrudRepository<GrupoModel, Long>, Serializable {
}