package trankhaidemo.sd17313.ViewModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HoaDonVm {
    private String Id;
    private String IdKH;
    private String IdNV;
    private String Ma;
    private Date NgayTao;
    private Date NgayThanhToan;
    private Date NgayShip;
    private Date NgayNhan;
    private int TinhTrang;
    private String TenNguoiNhan;
    private String DiaChi;
    private String Sdt;


}
