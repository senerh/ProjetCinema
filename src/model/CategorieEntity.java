package model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by nathan on 10/10/2016.
 */
@Entity
@Table(name = "categorie", schema = "cinema", catalog = "")
public class CategorieEntity {
    private String codeCat;
    private String libelleCat;
    private Collection<FilmEntity> filmsByCodeCat;

    @Id
    @Column(name = "CodeCat", nullable = false, length = 2)
    public String getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(String codeCat) {
        this.codeCat = codeCat;
    }

    @Basic
    @Column(name = "LibelleCat", nullable = false, length = 20)
    public String getLibelleCat() {
        return libelleCat;
    }

    public void setLibelleCat(String libelleCat) {
        this.libelleCat = libelleCat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategorieEntity that = (CategorieEntity) o;

        if (codeCat != null ? !codeCat.equals(that.codeCat) : that.codeCat != null) return false;
        if (libelleCat != null ? !libelleCat.equals(that.libelleCat) : that.libelleCat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codeCat != null ? codeCat.hashCode() : 0;
        result = 31 * result + (libelleCat != null ? libelleCat.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categorieByCodeCat")
    public Collection<FilmEntity> getFilmsByCodeCat() {
        return filmsByCodeCat;
    }

    public void setFilmsByCodeCat(Collection<FilmEntity> filmsByCodeCat) {
        this.filmsByCodeCat = filmsByCodeCat;
    }
}
