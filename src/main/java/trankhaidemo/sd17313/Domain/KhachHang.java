package trankhaidemo.sd17313.Domain;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.ViewModel.KhachHangVm;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Component
@Entity
@Table(name = "KhachHang")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class KhachHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID Id;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "Ten")
    private String Ten;

    @Column(name = "TenDem")
    private String TenDem;

    @Column(name = "Ho")
    private String Ho;

    @Column(name = "NgaySinh")
    private Date NgaySinh;

    @Column(name = "Sdt")
    private String Sdt;

    @Column(name = "DiaChi")
    private String DiaChi;

    @Column(name = "ThanhPho")
    private String ThanhPho;

    @Column(name = "QuocGia")
    private String QuocGia;

    @Column(name = "MatKhau")
    private String MatKhau;
    @OneToMany(mappedBy = "kh")
    private List<HoaDon> listHD;

    public void LoadformViewModel(KhachHangVm khachHangVm) {
        this.setMa(khachHangVm.getMa());
        this.setTen(khachHangVm.getTen());
        this.setTenDem(khachHangVm.getTendem());
        this.setHo(khachHangVm.getHo());
        this.setNgaySinh(khachHangVm.getNgaysinh());
        this.setSdt(khachHangVm.getSdt());
        this.setDiaChi(khachHangVm.getDiachi());
        this.setThanhPho(khachHangVm.getThanhpho());
        this.setQuocGia(khachHangVm.getQuocgia());
        this.setMatKhau(khachHangVm.getMatkhau());

    }
}
