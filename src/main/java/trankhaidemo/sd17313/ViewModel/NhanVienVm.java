package trankhaidemo.sd17313.ViewModel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import trankhaidemo.sd17313.Domain.ChucVu;
import trankhaidemo.sd17313.Domain.CuaHang;
import trankhaidemo.sd17313.Domain.NhanVien;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienVm {


    @NotBlank(message = "khong duoc de trong")
    private String ma;

    @NotBlank(message = "khong duoc de trong")
    private String ten;

    @NotBlank(message = "khong duoc de trong")
    private String tendem;

    @NotBlank(message = "khong duoc de trong")
    private String ho;

    @NotBlank(message = "khong duoc de trong")
    private String gioitinh;

    @NotBlank(message = "khong duoc de trong")
    private String ngaysinh;

    @NotBlank(message = "khong duoc de trong")
    private String diachi;

    @NotBlank(message = "khong duoc de trong")
    private String sdt;

    @NotBlank(message = "khong duoc de trong")
    private String matkhau;

    private CuaHang cuaHang;

    private ChucVu chucVu;
//    @NotBlank(message = "khong duoc de trong")
//    private String idguibc;


    private int trangthai;

    public void loadFromDomainModel(NhanVien dm) {
        this.setMa(dm.getMa());
        this.setTen(dm.getTen());
        this.setTendem(dm.getTenDem());
        this.setHo(dm.getHo());
        this.setGioitinh(dm.getGioitinh());
        this.setNgaysinh(String.valueOf(dm.getNgaysinh()));
        this.setDiachi(dm.getDiaChi());
        this.setSdt(dm.getSdt());
        this.setMatkhau(dm.getMatkhau());
        this.setTrangthai(dm.getTrangthai());
        this.setChucVu(dm.getChucVu());
        this.setCuaHang(dm.getCuaHang());
//        this.setIdguibc(dm.getIdguibc());

    }


}
