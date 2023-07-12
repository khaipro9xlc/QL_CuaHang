package trankhaidemo.sd17313.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trankhaidemo.sd17313.Domain.NSX;

import java.util.UUID;

@Repository
public interface NsxRepository extends JpaRepository<NSX, UUID> {
}
