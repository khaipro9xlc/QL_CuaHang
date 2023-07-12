package trankhaidemo.sd17313.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trankhaidemo.sd17313.Domain.ChiTietSP;

import java.util.UUID;

@Repository
public interface ChiTietSpRepository extends JpaRepository<ChiTietSP, UUID> {
}
