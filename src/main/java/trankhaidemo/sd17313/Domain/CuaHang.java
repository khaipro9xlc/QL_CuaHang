package trankhaidemo.sd17313.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.ViewModel.CuaHangVm;
import trankhaidemo.sd17313.ViewModel.NhanVienVm;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CuaHang")
public class CuaHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(name = "Ma")
    @NotBlank(message = "Khong duoc de trong Ma")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "Khong duoc de trong Ten")
    private String ten;

    @Column(name = "DiaChi")
    @NotBlank(message = "Khong duoc de trong DiaChi")
    private String diachi;

    @Column(name = "ThanhPho")
    @NotBlank(message = "Khong duoc de trong Thanh Pho")
    private String thanhpho;

    @Column(name = "QuocGia")
    @NotBlank(message = "Khong duoc de trong QuocGia")
    private String quocgia;

    @OneToMany(mappedBy = "cuaHang")
    List<NhanVien> lstnv;

    public void loadFromViewModel(CuaHangVm vm) {
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
        this.setDiachi(vm.getDiachi());
        this.setThanhpho(vm.getThanhpho());
        this.setQuocgia(vm.getQuocgia());


    }
}
