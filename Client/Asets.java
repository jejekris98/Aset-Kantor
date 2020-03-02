/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author jejek
 */
@Entity
@Table(name = "asets", catalog = "asetkantor", schema = "")
@NamedQueries({
    @NamedQuery(name = "Asets.findAll", query = "SELECT a FROM Asets a")
    , @NamedQuery(name = "Asets.findByIDBarang", query = "SELECT a FROM Asets a WHERE a.iDBarang = :iDBarang")
    , @NamedQuery(name = "Asets.findByNamaBarang", query = "SELECT a FROM Asets a WHERE a.namaBarang = :namaBarang")
    , @NamedQuery(name = "Asets.findByJumlah", query = "SELECT a FROM Asets a WHERE a.jumlah = :jumlah")
    , @NamedQuery(name = "Asets.findByRuangan", query = "SELECT a FROM Asets a WHERE a.ruangan = :ruangan")
    , @NamedQuery(name = "Asets.findByTglMasuk", query = "SELECT a FROM Asets a WHERE a.tglMasuk = :tglMasuk")
    , @NamedQuery(name = "Asets.findByTglKeluar", query = "SELECT a FROM Asets a WHERE a.tglKeluar = :tglKeluar")})
public class Asets implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_Barang")
    private Integer iDBarang;
    @Basic(optional = false)
    @Column(name = "Nama_Barang")
    private String namaBarang;
    @Basic(optional = false)
    @Column(name = "Jumlah")
    private int jumlah;
    @Basic(optional = false)
    @Column(name = "Ruangan")
    private String ruangan;
    @Basic(optional = false)
    @Column(name = "Tgl_Masuk")
    @Temporal(TemporalType.DATE)
    private Date tglMasuk;
    @Basic(optional = false)
    @Column(name = "Tgl_Keluar")
    @Temporal(TemporalType.DATE)
    private Date tglKeluar;

    public Asets() {
    }

    public Asets(Integer iDBarang) {
        this.iDBarang = iDBarang;
    }

    public Asets(Integer iDBarang, String namaBarang, int jumlah, String ruangan, Date tglMasuk, Date tglKeluar) {
        this.iDBarang = iDBarang;
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
        this.ruangan = ruangan;
        this.tglMasuk = tglMasuk;
        this.tglKeluar = tglKeluar;
    }

    public Integer getIDBarang() {
        return iDBarang;
    }

    public void setIDBarang(Integer iDBarang) {
        Integer oldIDBarang = this.iDBarang;
        this.iDBarang = iDBarang;
        changeSupport.firePropertyChange("IDBarang", oldIDBarang, iDBarang);
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        String oldNamaBarang = this.namaBarang;
        this.namaBarang = namaBarang;
        changeSupport.firePropertyChange("namaBarang", oldNamaBarang, namaBarang);
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        int oldJumlah = this.jumlah;
        this.jumlah = jumlah;
        changeSupport.firePropertyChange("jumlah", oldJumlah, jumlah);
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        String oldRuangan = this.ruangan;
        this.ruangan = ruangan;
        changeSupport.firePropertyChange("ruangan", oldRuangan, ruangan);
    }

    public Date getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(Date tglMasuk) {
        Date oldTglMasuk = this.tglMasuk;
        this.tglMasuk = tglMasuk;
        changeSupport.firePropertyChange("tglMasuk", oldTglMasuk, tglMasuk);
    }

    public Date getTglKeluar() {
        return tglKeluar;
    }

    public void setTglKeluar(Date tglKeluar) {
        Date oldTglKeluar = this.tglKeluar;
        this.tglKeluar = tglKeluar;
        changeSupport.firePropertyChange("tglKeluar", oldTglKeluar, tglKeluar);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDBarang != null ? iDBarang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asets)) {
            return false;
        }
        Asets other = (Asets) object;
        if ((this.iDBarang == null && other.iDBarang != null) || (this.iDBarang != null && !this.iDBarang.equals(other.iDBarang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client.Asets[ iDBarang=" + iDBarang + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
