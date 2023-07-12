package trankhaidemo.sd17313.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import trankhaidemo.sd17313.Domain.HoaDon;
import trankhaidemo.sd17313.Domain.HoaDonChiTiet;
import trankhaidemo.sd17313.Domain.HoaDonChiTietId;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonCtRepository extends JpaRepository<HoaDonChiTiet, HoaDonChiTietId> {
    @Query("FROM HoaDonChiTiet hdct where hdct.IdHoaDon = ?1")
    List<HoaDonChiTiet> getListHdct(UUID IDHD);
}
