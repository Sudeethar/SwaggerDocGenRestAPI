package com.radium.test.repository;

import com.radium.test.entities.Cd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CdRepository  extends JpaRepository<Cd, UUID> {
}
