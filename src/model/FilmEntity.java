package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by nathan on 10/10/2016.
 */
@Entity
@Table(name = "film", schema = "cinema", catalog = "")
public class FilmEntity {
    private int noFilm;
    private String titre;
    private int duree;
    private Date dateSortie;
    private int budget;
    private int montantRecette;
    private int noRea;
    private String codeCat;
    private RealisateurEntity realisateurByNoRea;
    private CategorieEntity categorieByCodeCat;
    private Collection<PersonnageEntity> personnagesByNoFilm;

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

    @Basic
    @Column(name = "NoRea", nullable = false)
    public int getNoRea() {
        return noRea;
    }

    public void setNoRea(int noRea) {
        this.noRea = noRea;
    }

    @Basic
    @Column(name = "CodeCat", nullable = false, length = 2)
    public String getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(String codeCat) {
        this.codeCat = codeCat;
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
        if (noRea != that.noRea) return false;
        if (titre != null ? !titre.equals(that.titre) : that.titre != null) return false;
        if (dateSortie != null ? !dateSortie.equals(that.dateSortie) : that.dateSortie != null) return false;
        if (codeCat != null ? !codeCat.equals(that.codeCat) : that.codeCat != null) return false;

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
        result = 31 * result + noRea;
        result = 31 * result + (codeCat != null ? codeCat.hashCode() : 0);
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
    public Collection<PersonnageEntity> getPersonnagesByNoFilm() {
        return personnagesByNoFilm;
    }

    public void setPersonnagesByNoFilm(Collection<PersonnageEntity> personnagesByNoFilm) {
        this.personnagesByNoFilm = personnagesByNoFilm;
    }
}
