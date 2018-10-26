package br.com.marteleto.esporte.core.model.interfaces;

import java.io.Serializable;

public interface IModel extends Serializable {
	void setId(Long id);
	Long getId();
}
