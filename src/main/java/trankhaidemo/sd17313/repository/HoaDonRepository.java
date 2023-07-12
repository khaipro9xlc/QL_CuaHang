package trankhaidemo.sd17313.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import trankhaidemo.sd17313.Domain.HoaDon;
import trankhaidemo.sd17313.Domain.KhachHang;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    @Query("FROM HoaDon HD WHERE HD.kh = ?1 and  HD.TinhTrang =1 or HD.TinhTrang=2 or HD.TinhTrang=3")
    List<HoaDon> lsthd(KhachHang khachHang);
}
