package trankhaidemo.sd17313.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import trankhaidemo.sd17313.ViewModel.ChiTietSanPhamVm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSP", referencedColumnName = "Id", nullable = true)
    private SanPham sp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNsx", referencedColumnName = "Id", nullable = true)
    private NSX nsx;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id", nullable = true)
    private MauSac ms;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id", nullable = true)
    private DongSP dsp;

    @Column(name = "NamBH")
    private int NamBH;

    @Column(name = "MoTa")
    private String MoTa;

    @Column(name = "SoLuongTon")
    private int SoLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal GiaNhap;

    @Column(name = "GiaBan")
    private BigDecimal GiaBan;


    public void loadFromViewModel(ChiTietSanPhamVm ctsp) {
        this.setSp(ctsp.getSp());
        this.setNsx(ctsp.getNsx());
        this.setMs(ctsp.getMauSac());
        this.setDsp(ctsp.getDongSP());
        this.setNamBH(ctsp.getNamBH());
        this.setMoTa(ctsp.getMota());
        this.setSoLuongTon(Integer.parseInt(ctsp.getSoLuongTon()));
        this.setGiaNhap(ctsp.getGiaNhap());
        this.setGiaBan(ctsp.getGiaBan());

    }

}
