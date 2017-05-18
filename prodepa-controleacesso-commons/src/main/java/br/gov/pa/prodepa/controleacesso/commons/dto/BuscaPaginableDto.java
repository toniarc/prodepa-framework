package br.gov.pa.prodepa.controleacesso.commons.dto;

import java.io.Serializable;

public class BuscaPaginableDto implements Serializable {

  private static final long serialVersionUID = -2577927638522462248L;

  private Integer inicio, quantidade;
  private int pageNumber, rowCount;

  public BuscaPaginableDto() {
    super();
    this.pageNumber = 1;
    this.rowCount = -1;
  }

  public Integer getInicio() {
    return inicio;
  }

  public void setInicio(Integer inicio) {
    this.inicio = inicio;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  public int getRowCount() {
    return rowCount;
  }

  public void setRowCount(int rowCount) {
    this.rowCount = rowCount;
  }

  public boolean isEmpty() {
    return rowCount == 0;
  }

  public boolean isNotEmpty() {
    return rowCount > 0;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
    result = prime * result + pageNumber;
    result = prime * result
        + ((quantidade == null) ? 0 : quantidade.hashCode());
    result = prime * result + rowCount;
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
    BuscaPaginableDto other = (BuscaPaginableDto) obj;
    if (inicio == null) {
      if (other.inicio != null)
        return false;
    } else if (!inicio.equals(other.inicio))
      return false;
    if (pageNumber != other.pageNumber)
      return false;
    if (quantidade == null) {
      if (other.quantidade != null)
        return false;
    } else if (!quantidade.equals(other.quantidade))
      return false;
    if (rowCount != other.rowCount)
      return false;
    return true;
  }
}