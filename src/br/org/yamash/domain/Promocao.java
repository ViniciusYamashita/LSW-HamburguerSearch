package br.org.yamash.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Promocao")
public class Promocao {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codPromocao")
	private long codPromocao;
	 
	@NotNull(message="O campo 'Tipo de Promoção' é obrigatório.")
	@Column(name="tipoPromocao", nullable=false)
	private int tipoPromocao;
	 
	@NotNull(message="O campo 'Data início' é obrigatório.")
	@Column(name="dtInicio", columnDefinition="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtInicio;
	
	@NotNull(message="O campo 'Data Fim' é obrigatório.")
	@Column(name="dtFim", columnDefinition="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtFim;
	 
	@NotEmpty(message="O campo 'Valor da promoção' é obrigatório.")
	@Column(name="valorPromcao", length=6, nullable=false)
	private String valorPromocao;

	
	
	public long getCodPromocao() {
		return codPromocao;
	}

	public void setCodPromocao(long codPromocao) {
		this.codPromocao = codPromocao;
	}

	public int getTipoPromocao() {
		return tipoPromocao;
	}

	public void setTipoPromocao(int tipoPromocao) {
		this.tipoPromocao = tipoPromocao;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public String getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(String valorPromocao) {
		this.valorPromocao = valorPromocao;
	}
	 
}
 
