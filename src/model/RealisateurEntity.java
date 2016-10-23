package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nathan on 10/10/2016.
 */
@Entity
@Table(name = "realisateur", schema = "cinema", catalog = "")
public class RealisateurEntity {
    private int noRea;
    private String nomRea;
    private String prenRea;
    private List<FilmEntity> filmsByNoRea;

    @Id
    @Column(name = "NoRea", nullable = false)
    public int getNoRea() {
        return noRea;
    }

    public void setNoRea(int noRea) {
        this.noRea = noRea;
    }

    @Basic
    @Column(name = "NomRea", nullable = false, length = 20)
    public String getNomRea() {
        return nomRea;
    }

    public void setNomRea(String nomRea) {
        this.nomRea = nomRea;
    }

    @Basic
    @Column(name = "PrenRea", nullable = false, length = 20)
    public String getPrenRea() {
        return prenRea;
    }

    public void setPrenRea(String prenRea) {
        this.prenRea = prenRea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RealisateurEntity that = (RealisateurEntity) o;

        if (noRea != that.noRea) return false;
        if (nomRea != null ? !nomRea.equals(that.nomRea) : that.nomRea != null) return false;
        if (prenRea != null ? !prenRea.equals(that.prenRea) : that.prenRea != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noRea;
        result = 31 * result + (nomRea != null ? nomRea.hashCode() : 0);
        result = 31 * result + (prenRea != null ? prenRea.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "realisateurByNoRea")
    public List<FilmEntity> getFilmsByNoRea() {
        return filmsByNoRea;
    }

    public void setFilmsByNoRea(List<FilmEntity> filmsByNoRea) {
        this.filmsByNoRea = filmsByNoRea;
    }
}
