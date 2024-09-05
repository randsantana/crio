package api.de.gerenciamento.de.eventos.repository;

import api.de.gerenciamento.de.eventos.dumain.convite.Convite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConviteRepository extends JpaRepository<Convite, UUID> {
}