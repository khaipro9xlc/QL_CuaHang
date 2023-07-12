package trankhaidemo.sd17313.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import trankhaidemo.sd17313.Domain.NhanVien;

import java.util.UUID;

@Repository
public interface NhanVienRopository extends JpaRepository<NhanVien, UUID> {
    @Query("FROM NhanVien nv where nv.ma =?1 and  nv.matkhau=?2")
    public NhanVien login(String ma, String matkhau);
}
