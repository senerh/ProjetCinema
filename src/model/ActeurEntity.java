package model;

import util.SqlDateAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "acteur", schema = "cinema", catalog = "")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ActeurEntity {
    private int noAct;
    private String nomAct;
    private String prenAct;
    @XmlJavaTypeAdapter(SqlDateAdapter.class)
    private Date dateNaiss;
    @XmlJavaTypeAdapter(SqlDateAdapter.class)
    private Date dateDeces;
    @XmlTransient
    private List<PersonnageEntity> personnagesByNoAct;

    @Id
    @Column(name = "NoAct", nullable = false)
    public int getNoAct() {
        return noAct;
    }

    public void setNoAct(int noAct) {
        this.noAct = noAct;
    }

    @Basic
    @Column(name = "NomAct", nullable = false, length = 20)
    public String getNomAct() {
        return nomAct;
    }

    public void setNomAct(String nomAct) {
        this.nomAct = nomAct;
    }

    @Basic
    @Column(name = "PrenAct", nullable = true, length = 20)
    public String getPrenAct() {
        return prenAct;
    }

    public void setPrenAct(String prenAct) {
        this.prenAct = prenAct;
    }

    @Basic
    @Column(name = "DateNaiss", nullable = true)
    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    @Basic
    @Column(name = "DateDeces", nullable = true)
    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActeurEntity that = (ActeurEntity) o;

        if (noAct != that.noAct) return false;
        if (nomAct != null ? !nomAct.equals(that.nomAct) : that.nomAct != null) return false;
        if (prenAct != null ? !prenAct.equals(that.prenAct) : that.prenAct != null) return false;
        if (dateNaiss != null ? !dateNaiss.equals(that.dateNaiss) : that.dateNaiss != null) return false;
        if (dateDeces != null ? !dateDeces.equals(that.dateDeces) : that.dateDeces != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noAct;
        result = 31 * result + (nomAct != null ? nomAct.hashCode() : 0);
        result = 31 * result + (prenAct != null ? prenAct.hashCode() : 0);
        result = 31 * result + (dateNaiss != null ? dateNaiss.hashCode() : 0);
        result = 31 * result + (dateDeces != null ? dateDeces.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "acteurByNoAct")
    public List<PersonnageEntity> getPersonnagesByNoAct() {
        return personnagesByNoAct;
    }

    public void setPersonnagesByNoAct(List<PersonnageEntity> personnagesByNoAct) {
        this.personnagesByNoAct = personnagesByNoAct;
    }
}
