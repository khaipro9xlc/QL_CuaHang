package trankhaidemo.sd17313.ViewModel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.Domain.KhachHang;

import java.sql.Date;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class KhachHangVm {

    @NotBlank(message = "Khong duoc de trong")
    private String ma;
    @NotBlank(message = "Khong duoc de trong")
    private String ten;
    @NotBlank(message = "Khong duoc de trong")
    private String tendem;
    @NotBlank(message = "Khong duoc de trong")
    private String ho;

    private Date ngaysinh;
    @NotBlank(message = "Khong duoc de trong")
    private String sdt;
    @NotBlank(message = "Khong duoc de trong")
    private String diachi;
    @NotBlank(message = "Khong duoc de trong")
    private String thanhpho;
    @NotBlank(message = "Khong duoc de trong")
    private String quocgia;
    @NotBlank(message = "Khong duoc de trong")
    private String matkhau;

    public void LoadformDomainModel(KhachHang khachHang) {
        this.setMa(khachHang.getMa());
        this.setTen(khachHang.getTen());
        this.setTendem(khachHang.getTenDem());
        this.setHo(khachHang.getHo());
        this.setNgaysinh(khachHang.getNgaySinh());
        this.setSdt(khachHang.getSdt());
        this.setDiachi(khachHang.getDiaChi());
        this.setThanhpho(khachHang.getThanhPho());
        this.setQuocgia(khachHang.getQuocGia());
        this.setMatkhau(khachHang.getMatKhau());

    }
}
