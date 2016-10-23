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

/**
 * Created by nathan on 10/10/2016.
 */
@Entity
@Table(name = "film", schema = "cinema", catalog = "")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FilmEntity {
    private int noFilm;
    private String titre;
    private int duree;
    @XmlJavaTypeAdapter(SqlDateAdapter.class)
    private Date dateSortie;
    private int budget;
    private int montantRecette;
    @XmlTransient
    private RealisateurEntity realisateurByNoRea;
    @XmlTransient
    private CategorieEntity categorieByCodeCat;
    @XmlTransient
    private List<PersonnageEntity> personnagesByNoFilm;

    @Id
    @Column(name = "NoFilm", nullable = false)
    public int getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(int noFilm) {
        this.noFilm = noFilm;
    }

    @Basic
    @Column(name = "Titre", nullable = false, length = 30)
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Basic
    @Column(name = "Duree", nullable = false)
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Basic
    @Column(name = "DateSortie", nullable = false)
    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    @Basic
    @Column(name = "Budget", nullable = false)
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "MontantRecette", nullable = false)
    public int getMontantRecette() {
        return montantRecette;
    }

    public void setMontantRecette(int montantRecette) {
        this.montantRecette = montantRecette;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmEntity that = (FilmEntity) o;

        if (noFilm != that.noFilm) return false;
        if (duree != that.duree) return false;
        if (budget != that.budget) return false;
        if (montantRecette != that.montantRecette) return false;
        if (titre != null ? !titre.equals(that.titre) : that.titre != null) return false;
        if (dateSortie != null ? !dateSortie.equals(that.dateSortie) : that.dateSortie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noFilm;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
        result = 31 * result + duree;
        result = 31 * result + (dateSortie != null ? dateSortie.hashCode() : 0);
        result = 31 * result + budget;
        result = 31 * result + montantRecette;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NoRea", referencedColumnName = "NoRea", nullable = false)
    public RealisateurEntity getRealisateurByNoRea() {
        return realisateurByNoRea;
    }

    public void setRealisateurByNoRea(RealisateurEntity realisateurByNoRea) {
        this.realisateurByNoRea = realisateurByNoRea;
    }

    @ManyToOne
    @JoinColumn(name = "CodeCat", referencedColumnName = "CodeCat", nullable = false)
    public CategorieEntity getCategorieByCodeCat() {
        return categorieByCodeCat;
    }

    public void setCategorieByCodeCat(CategorieEntity categorieByCodeCat) {
        this.categorieByCodeCat = categorieByCodeCat;
    }

    @OneToMany(mappedBy = "filmByNoFilm")
    public List<PersonnageEntity> getPersonnagesByNoFilm() {
        return personnagesByNoFilm;
    }

    public void setPersonnagesByNoFilm(List<PersonnageEntity> personnagesByNoFilm) {
        this.personnagesByNoFilm = personnagesByNoFilm;
    }
}
