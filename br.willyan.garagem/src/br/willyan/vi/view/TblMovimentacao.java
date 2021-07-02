/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.willyan.vi.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@Table(name = "tbl_movimentacao", catalog = "titan", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblMovimentacao.findAll", query = "SELECT t FROM TblMovimentacao t")
    , @NamedQuery(name = "TblMovimentacao.findById", query = "SELECT t FROM TblMovimentacao t WHERE t.id = :id")
    , @NamedQuery(name = "TblMovimentacao.findByPlaca", query = "SELECT t FROM TblMovimentacao t WHERE t.placa = :placa")
    , @NamedQuery(name = "TblMovimentacao.findByModelo", query = "SELECT t FROM TblMovimentacao t WHERE t.modelo = :modelo")
    , @NamedQuery(name = "TblMovimentacao.findByDataEntrada", query = "SELECT t FROM TblMovimentacao t WHERE t.dataEntrada = :dataEntrada")
    , @NamedQuery(name = "TblMovimentacao.findByDataSaida", query = "SELECT t FROM TblMovimentacao t WHERE t.dataSaida = :dataSaida")
    , @NamedQuery(name = "TblMovimentacao.findByTempo", query = "SELECT t FROM TblMovimentacao t WHERE t.tempo = :tempo")
    , @NamedQuery(name = "TblMovimentacao.findByValorPago", query = "SELECT t FROM TblMovimentacao t WHERE t.valorPago = :valorPago")})
public class TblMovimentacao implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "placa")
    private String placa;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "data_entrada")
    private String dataEntrada;
    @Column(name = "data_saida")
    private String dataSaida;
    @Basic(optional = false)
    @Column(name = "tempo")
    private float tempo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_pago")
    private Float valorPago;

    
    
    public TblMovimentacao() {
    }

    public TblMovimentacao(Integer id) {
        this.id = id;
    }

    public TblMovimentacao(Integer id, float tempo) {
        this.id = id;
        this.tempo = tempo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        String oldPlaca = this.placa;
        this.placa = placa;
        changeSupport.firePropertyChange("placa", oldPlaca, placa);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        String oldDataEntrada = this.dataEntrada;
          
// pegar data do sistema operacional 
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YY");
        
        dataEntrada = formatador.format(data);
        this.dataEntrada = dataEntrada;
        
       
        
        changeSupport.firePropertyChange("dataEntrada", oldDataEntrada, dataEntrada);
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        String oldDataSaida = this.dataSaida;
        this.dataSaida = dataSaida;
        changeSupport.firePropertyChange("dataSaida", oldDataSaida, dataSaida);
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        float oldTempo = this.tempo;
        this.tempo = tempo;
        
        
        changeSupport.firePropertyChange("tempo", oldTempo, tempo);
    }

    public Float getValorPago() {
        return valorPago;
    }

    public void setValorPago(Float valorPago) {
       /* 
       TblValor tb = new TblValor();
       float p = tb.getValorPrimeiraHora();
       float d = tb.getValorDemaisHoras();
       */
       
      
       
        Float oldValorPago = this.valorPago;
     
        
        
        //caculo do valor pago 
        float t = getTempo();
        int inicial, demais;
        Integer total;
        if (t>1){
            inicial=6; //inicial=(int)p;
            demais = (int)((t-1)*4); //demais = (int)((t-1)* (int)d)
            total = inicial + demais;        
        } else {
          total = 6;  
        }
        valorPago=total.floatValue();
        this.valorPago = valorPago;
        changeSupport.firePropertyChange("valorPago", oldValorPago, valorPago);
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
        if (!(object instanceof TblMovimentacao)) {
            return false;
        }
        TblMovimentacao other = (TblMovimentacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.willyan.vi.view.TblMovimentacao[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
