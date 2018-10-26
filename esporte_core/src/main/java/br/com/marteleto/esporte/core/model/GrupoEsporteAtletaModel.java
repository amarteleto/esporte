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
		name="TB_GRUPO_ESPORTE_ATLETA"
		,uniqueConstraints={
				@UniqueConstraint(name="UN_GRAT_CHAVE_CANDIDATA",columnNames={"SQ_ATLE_ATLETA","SQ_GRES_GRUPO_ESPORTE"})
		}
		,indexes={
				@Index(name="PK_GREA",columnList="SQ_GREA_GRUPO_ESPORTE_ATLETA"),
				@Index(name="IX_GRAT_CHAVE_CANDIDATA",columnList="SQ_ATLE_ATLETA,SQ_GRES_GRUPO_ESPORTE"),
				@Index(name="IX_FK_GRES_GRAT",columnList="SQ_GRES_GRUPO_ESPORTE"),
				@Index(name="IX_FK_ATLE_GRAT",columnList="SQ_ATLE_ATLETA"),
		}
)
@AttributeOverride(name="id", column=@Column(name="SQ_GREA_GRUPO_ESPORTE_ATLETA",nullable=false,columnDefinition="INT"))
public class GrupoEsporteAtletaModel extends AModel {
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="SQ_GRES_GRUPO_ESPORTE",nullable=false,foreignKey=@ForeignKey(name="FK_GRES_GRAT"))
	private GrupoEsporteModel grupoEsporte;
	
	@ManyToOne
	@JoinColumn(name="SQ_ATLE_ATLETA",nullable=false,foreignKey=@ForeignKey(name="FK_ATLE_GRAT"))
	private AtletaModel atleta;
	
	public GrupoEsporteModel getGrupoEsporte() {
		return grupoEsporte;
	}
	public void setGrupoEsporte(GrupoEsporteModel grupoEsporte) {
		this.grupoEsporte = grupoEsporte;
	}
	public AtletaModel getAtleta() {
		return atleta;
	}
	public void setAtleta(AtletaModel atleta) {
		this.atleta = atleta;
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
