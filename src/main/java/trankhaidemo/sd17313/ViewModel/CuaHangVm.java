package trankhaidemo.sd17313.ViewModel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.Domain.CuaHang;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CuaHangVm {
    @NotBlank(message = "Khong duoc de trong")
    private String ma;
    @NotBlank(message = "Khong duoc de trong")
    private String ten;
    @NotBlank(message = "Khong duoc de trong")
    private String diachi;
    @NotBlank(message = "Khong duoc de trong")
    private String thanhpho;
    @NotBlank(message = "Khong duoc de trong")
    private String quocgia;


    public void loadFromDomainModel(CuaHang dm) {
        this.setMa(dm.getMa());
        this.setTen(dm.getTen());
        this.setDiachi(dm.getDiachi());
        this.setThanhpho(dm.getThanhpho());
        this.setQuocgia(dm.getQuocgia());

    }
}
