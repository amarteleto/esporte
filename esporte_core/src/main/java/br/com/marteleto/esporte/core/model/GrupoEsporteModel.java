package br.com.marteleto.esporte.core.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.marteleto.esporte.core.model.abstracts.AModel;

@Entity
@Table(
		name="TB_GRUPO_ESPORTE"
		,uniqueConstraints={
				@UniqueConstraint(name="UN_GRES_GRUPO_ESPORTE",columnNames={"SQ_GRUP_GRUPO","SQ_ESPO_ESPORTE"})
		}
		,indexes={
				@Index(name="PK_GRES",columnList="SQ_GRES_GRUPO_ESPORTE"),
				@Index(name="IX_GRES_GRUPO_ESPORTE",columnList="SQ_GRUP_GRUPO,SQ_ESPO_ESPORTE"),
				@Index(name="IX_FK_GRUP_GRES",columnList="SQ_GRUP_GRUPO"),
				@Index(name="IX_FK_ESPO_GRES",columnList="SQ_ESPO_ESPORTE"),
		}
)
@AttributeOverride(name="id", column=@Column(name="SQ_GRES_GRUPO_ESPORTE",nullable=false,columnDefinition="INT"))
public class GrupoEsporteModel extends AModel {
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="SQ_GRUP_GRUPO",nullable=false,foreignKey=@ForeignKey(name="FK_GRUP_GRES"))
	private GrupoModel grupo;
	
	@ManyToOne
	@JoinColumn(name="SQ_ESPO_ESPORTE",nullable=false,foreignKey=@ForeignKey(name="FK_ESPO_GRES"))
	private EsporteModel esporte;
	
	public GrupoModel getGrupo() {
		return grupo;
	}
	public void setGrupo(GrupoModel grupo) {
		this.grupo = grupo;
	}
	public EsporteModel getEsporte() {
		return esporte;
	}
	public void setEsporte(EsporteModel esporte) {
		this.esporte = esporte;
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
