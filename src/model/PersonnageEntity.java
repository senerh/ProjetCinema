package model;

import javax.persistence.*;

/**
 * Created by nathan on 10/10/2016.
 */
@Entity
@Table(name = "personnage", schema = "cinema", catalog = "")
@IdClass(PersonnageEntityPK.class)
public class PersonnageEntity {
    private int noFilm;
    private int noAct;
    private String nomPers;
    private FilmEntity filmByNoFilm;
    private ActeurEntity acteurByNoAct;

    @Id
    @Column(name = "NoFilm", nullable = false)
    public int getNoFilm() {
        return noFilm;
    }

    public void setNoFilm(int noFilm) {
        this.noFilm = noFilm;
    }

    @Id
    @Column(name = "NoAct", nullable = false)
    public int getNoAct() {
        return noAct;
    }

    public void setNoAct(int noAct) {
        this.noAct = noAct;
    }

    @Basic
    @Column(name = "NomPers", nullable = false, length = 30)
    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonnageEntity that = (PersonnageEntity) o;

        if (noFilm != that.noFilm) return false;
        if (noAct != that.noAct) return false;
        if (nomPers != null ? !nomPers.equals(that.nomPers) : that.nomPers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noFilm;
        result = 31 * result + noAct;
        result = 31 * result + (nomPers != null ? nomPers.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "NoFilm", referencedColumnName = "NoFilm", nullable = false, insertable = false, updatable = false)
    public FilmEntity getFilmByNoFilm() {
        return filmByNoFilm;
    }

    public void setFilmByNoFilm(FilmEntity filmByNoFilm) {
        this.filmByNoFilm = filmByNoFilm;
    }

    @ManyToOne
    @JoinColumn(name = "NoAct", referencedColumnName = "NoAct", nullable = false, insertable = false, updatable = false)
    public ActeurEntity getActeurByNoAct() {
        return acteurByNoAct;
    }

    public void setActeurByNoAct(ActeurEntity acteurByNoAct) {
        this.acteurByNoAct = acteurByNoAct;
    }
}
