package trankhaidemo.sd17313.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.ViewModel.NhanVienVm;


import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVien {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "GioiTinh")
    private String gioitinh;

    @Column(name = "NgaySinh")
    private Date ngaysinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "MatKhau")
    private String matkhau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCH", referencedColumnName = "Id", nullable = true)
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV", referencedColumnName = "Id", nullable = true)
    private ChucVu chucVu;

//    @Column(name = "IdGuiBC")
//    private String idguibc;

    @Column(name = "TrangThai")
    private int trangthai;

    public void loadFromViewModel(NhanVienVm vm) {
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
        this.setTenDem(vm.getTendem());
        this.setHo(vm.getHo());
        this.setGioitinh(vm.getGioitinh());
        this.setNgaysinh(Date.valueOf(vm.getNgaysinh()));
        this.setDiaChi(vm.getDiachi());
        this.setSdt(vm.getSdt());
        this.setMatkhau(vm.getMatkhau());
        this.setTrangthai(vm.getTrangthai());
        this.setChucVu(vm.getChucVu());
//        this.setIdguibc(vm.getIdguibc());
        this.setCuaHang(vm.getCuaHang());

    }


}
