package trankhaidemo.sd17313.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import trankhaidemo.sd17313.Domain.KhachHang;

import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    @Query("FROM KhachHang khObj where khObj.Ma like ?1 and khObj.MatKhau like ?2")
    public KhachHang khachHangLogin(String ma, String matkhau);
}
