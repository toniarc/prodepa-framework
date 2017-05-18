package br.gov.pa.prodepa.controleacesso.commons.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.gov.pa.prodepa.domain.Model;

@Entity
@Table(name="historico_senha", schema = "controleacesso")
public class HistoricoSenha implements Model {

  private static final long serialVersionUID = -718468719154273514L;

  private Long id;

  private Usuario usuario;

  private Date data;

  private String senha;
  
  public HistoricoSenha() {
    super();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_generator")
  @SequenceGenerator(name = "sq_generator", sequenceName = "controleacesso.sq_historico_senha", allocationSize = 1)
  @Column(name="id", nullable = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @ManyToOne
  @JoinColumn(name = "id_usuario", nullable = false)
  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "data_hora", nullable = false)
  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  @Column(name = "senha", nullable = false)
  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((data == null) ? 0 : data.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((senha == null) ? 0 : senha.hashCode());
    result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
    HistoricoSenha other = (HistoricoSenha) obj;
    if (data == null) {
      if (other.data != null)
        return false;
    } else if (!data.equals(other.data))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (senha == null) {
      if (other.senha != null)
        return false;
    } else if (!senha.equals(other.senha))
      return false;
    if (usuario == null) {
      if (other.usuario != null)
        return false;
    } else if (!usuario.equals(other.usuario))
      return false;
    return true;
  }
}