package nz.co.pfr.art.Music.repository;

import nz.co.pfr.art.Music.entities.Cd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CdRepository  extends JpaRepository<Cd, UUID> {
}
