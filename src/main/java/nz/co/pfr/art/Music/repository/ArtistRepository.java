package nz.co.pfr.art.Music.repository;

import jakarta.persistence.Tuple;
import nz.co.pfr.art.Music.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ArtistRepository extends JpaRepository<Artist, UUID> {


    @Query(value = "select a.name, count(t) as trackcount from artist a " +
            "inner join cd c on a.artistid = c.artistid " +
            "inner join track t on t.cdid = c.cdid " +
            " group by a.name order by " +
            " trackcount desc limit =: topn")
    List<Tuple>  mostProductiveSQL (@Param("status") Integer topn);

}
