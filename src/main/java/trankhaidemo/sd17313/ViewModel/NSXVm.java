package trankhaidemo.sd17313.ViewModel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.Domain.NSX;
import trankhaidemo.sd17313.Domain.SanPham;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NSXVm {
    @NotBlank(message = "Không được để trống")
    private String ma;
    @NotBlank(message = "Không được để trống")
    private String ten;

    public void loadFromDomainModel(NSX nsx) {
        this.setMa(nsx.getMa());
        this.setTen(nsx.getTen());
    }

}
