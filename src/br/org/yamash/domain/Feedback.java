package br.org.yamash.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codFeedback")
	private long codFeedback;
	 
	@NotNull(message="O campo 'Empresa' é obrigatório.")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codEmpresas", referencedColumnName="codEmpresa")
	private Empresa codEmpresa;
	 
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codItem", referencedColumnName="codItem")
	private Item codItem;
	 
	@NotNull(message="O campo 'Cliente' é obrigatório.")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="codCliente", referencedColumnName="codCliente")
	private Clientes codCliente;
	 
	@Column(name="dtFeedback", columnDefinition="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtFeedback;
	
	@NotNull(message="A 'Média' é obrigatória para o Feedback.")
	@Column(name="valorMedia", nullable=false)
	private Integer valorMedia;
	 
	@NotEmpty(message="Para realizar o Feedback não se esqueça de preencher o campo 'Comentario'.")
	@Size(min=3, message="Para que a empresa possa melhorar os comentarios devem ter no minimo 3 caracteres, ou seja apenas uma palavra.")
	@Column(name="comentario", length=500, nullable=false)
	private String comentario;

	public long getCodFeedback() {
		return codFeedback;
	}

	public void setCodFeedback(long codFeedback) {
		this.codFeedback = codFeedback;
	}

	public Empresa getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(Empresa codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public Item getCodItem() {
		return codItem;
	}

	public void setCodItem(Item codItem) {
		this.codItem = codItem;
	}

	public Clientes getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Clientes codCliente) {
		this.codCliente = codCliente;
	}

	public Date getDtFeedback() {
		return dtFeedback;
	}

	public void setDtFeedback(Date dtFeedback) {
		this.dtFeedback = dtFeedback;
	}

	public Integer getValorMedia() {
		return valorMedia;
	}

	public void setValorMedia(Integer valorMedia) {
		this.valorMedia = valorMedia;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codFeedback ^ (codFeedback >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		if (codFeedback != other.codFeedback)
			return false;
		return true;
	}
	 	 
}
 
