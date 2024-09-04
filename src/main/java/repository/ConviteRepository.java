package repository;

import dumain.convite.Convite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConviteRepository extends JpaRepository<Convite, UUID> {
}