package trankhaidemo.sd17313.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trankhaidemo.sd17313.Domain.DongSP;

import java.util.UUID;

@Repository
public interface DongSpRepository extends JpaRepository<DongSP, UUID> {
}
