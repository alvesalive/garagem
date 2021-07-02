/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.willyan.vi.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Willyan
 */
@Entity
@Table(name = "tbl_valor", catalog = "titan", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblValor.findAll", query = "SELECT t FROM TblValor t")
    , @NamedQuery(name = "TblValor.findById", query = "SELECT t FROM TblValor t WHERE t.id = :id")
    , @NamedQuery(name = "TblValor.findByValorPrimeiraHora", query = "SELECT t FROM TblValor t WHERE t.valorPrimeiraHora = :valorPrimeiraHora")
    , @NamedQuery(name = "TblValor.findByValorDemaisHoras", query = "SELECT t FROM TblValor t WHERE t.valorDemaisHoras = :valorDemaisHoras")
    , @NamedQuery(name = "TblValor.findByDataFim", query = "SELECT t FROM TblValor t WHERE t.dataFim = :dataFim")})
public class TblValor implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_primeira_hora")
    private Float valorPrimeiraHora;
    @Basic(optional = false)
    @Column(name = "valor_demais_horas")
    private float valorDemaisHoras;
    @Column(name = "data_fim")
    private String dataFim;

    public TblValor() {
    }

    public TblValor(Integer id) {
        this.id = id;
    }

    public TblValor(Integer id, float valorDemaisHoras) {
        this.id = id;
        this.valorDemaisHoras = valorDemaisHoras;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Float getValorPrimeiraHora() {
        return valorPrimeiraHora;
    }

    public void setValorPrimeiraHora(Float valorPrimeiraHora) {
        Float oldValorPrimeiraHora = this.valorPrimeiraHora;
        this.valorPrimeiraHora = valorPrimeiraHora;
        changeSupport.firePropertyChange("valorPrimeiraHora", oldValorPrimeiraHora, valorPrimeiraHora);
    }

    public float getValorDemaisHoras() {
        return valorDemaisHoras;
    }

    public void setValorDemaisHoras(float valorDemaisHoras) {
        float oldValorDemaisHoras = this.valorDemaisHoras;
        this.valorDemaisHoras = valorDemaisHoras;
        changeSupport.firePropertyChange("valorDemaisHoras", oldValorDemaisHoras, valorDemaisHoras);
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        String oldDataFim = this.dataFim;
        this.dataFim = dataFim;
        changeSupport.firePropertyChange("dataFim", oldDataFim, dataFim);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblValor)) {
            return false;
        }
        TblValor other = (TblValor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.willyan.vi.view.TblValor[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
