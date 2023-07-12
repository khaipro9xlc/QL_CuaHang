package trankhaidemo.sd17313.ViewModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.Domain.*;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ChiTietSanPhamVm {

    private SanPham sp;
    private NSX nsx;
    private MauSac mauSac;
    private DongSP dongSP;

    private int NamBH;

    @NotBlank(message = "not null")
    private String Mota;

    @NotBlank(message = "khong duoc de trong")
    private String SoLuongTon;

    private BigDecimal GiaNhap;

    private BigDecimal GiaBan;

    public void loadFromDomainModel(ChiTietSP ctspvm) {
        this.setSp(ctspvm.getSp());
        this.setNsx(ctspvm.getNsx());
        this.setMauSac(ctspvm.getMs());
        this.setDongSP(ctspvm.getDsp());
        this.setNamBH(ctspvm.getNamBH());
        this.setMota(ctspvm.getMoTa());
        this.setSoLuongTon(String.valueOf(ctspvm.getSoLuongTon()));
        this.setGiaNhap(ctspvm.getGiaNhap());
        this.setGiaBan(ctspvm.getGiaBan());

    }
}