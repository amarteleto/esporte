package br.com.marteleto.esporte.core.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.marteleto.esporte.core.model.abstracts.AModel;

@Entity
@Table(
		name="TB_GRUPO"
		,uniqueConstraints={
				@UniqueConstraint(name="UN_GRUP_CHAVE_CANDIDATA",columnNames={"NM_GRUP_GRUPO"})
		}
		,indexes={
				@Index(name="PK_GRUP",columnList="SQ_GRUP_GRUPO"),
				@Index(name="IX_GRUP_CHAVE_CANDIDATA",columnList="NM_GRUP_GRUPO")
		}
)
@AttributeOverride(name="id", column=@Column(name="SQ_GRUP_GRUPO",nullable=false,columnDefinition="INT"))
@SequenceGenerator(name="SQ_GRUP_GRUPO",sequenceName="SQ_GRUP_GRUPO", allocationSize=1)
public class GrupoModel extends AModel {
	private static final long serialVersionUID = 1L;
	@Column(name="NM_GRUP_GRUPO",nullable=false,columnDefinition="VARCHAR(45)")
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
