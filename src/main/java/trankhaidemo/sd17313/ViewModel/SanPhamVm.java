package trankhaidemo.sd17313.ViewModel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.Domain.ChucVu;
import trankhaidemo.sd17313.Domain.SanPham;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPhamVm {
    @NotBlank(message = "không được để trống")
    private String ma;
    @NotBlank(message = "không được để trống")
    private String ten;

    public void loadFromDomainModel(SanPham sanPham) {
        this.setMa(sanPham.getMa());
        this.setTen(sanPham.getTen());
    }

}
