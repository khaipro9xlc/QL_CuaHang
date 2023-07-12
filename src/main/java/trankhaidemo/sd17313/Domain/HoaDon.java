package trankhaidemo.sd17313.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Entity
@Table(name = "HoaDon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDon {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKH", referencedColumnName = "Id", nullable = true)
    private KhachHang kh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNV", referencedColumnName = "Id", nullable = true)
    private NhanVien nv;
    @Column(name = "Ma")
    private String Ma;
    @Column(name = "NgayTao")
    private Date NgayTao;
    @Column(name = "NgayThanhToan")
    private Date NgayThanhToan;
    @Column(name = "NgayShip")
    private Date NgayShip;
    @Column(name = "NgayNhan")
    private Date NgayNhan;
    @Column(name = "TinhTrang")
    private int TinhTrang;
    @Column(name = "TenNguoiNhan")
    private String TenNguoiNhan;
    @Column(name = "DiaChi")
    private String DiaChi;
    @Column(name = "Sdt")
    private String Sdt;

    public String getTrangThai() {
        if (TinhTrang == 1) {
            return "Dang Cho Xu Ly";
        } else if (TinhTrang == 2) {
            return "Thanh Toan Thanh Cong";
        } else if (TinhTrang == 3) {
            return "Thanh toan khong thanh cong";
        } else {
            return "Đang chờ xử lý";
        }
    }
}
