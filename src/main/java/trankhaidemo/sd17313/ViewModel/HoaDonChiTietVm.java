package trankhaidemo.sd17313.ViewModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trankhaidemo.sd17313.Domain.SanPham;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HoaDonChiTietVm {
    private String IdHoaDon;
    private SanPham sp;
    private int SoLuong;
    private BigDecimal DonGia;


}
