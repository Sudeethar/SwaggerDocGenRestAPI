package nz.co.pfr.art.Music.repository;

import nz.co.pfr.art.Music.entities.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackRepository extends JpaRepository<Track, UUID> {
}