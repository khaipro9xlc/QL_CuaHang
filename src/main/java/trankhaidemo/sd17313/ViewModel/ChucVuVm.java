package trankhaidemo.sd17313.ViewModel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.Domain.ChucVu;
import trankhaidemo.sd17313.Domain.DongSP;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChucVuVm {

    @NotBlank(message = "Khong duoc de trong")
    private String ma;
    @NotBlank(message = "Khong duoc de trong")
    private String ten;

    public void loadFromDomainModel(ChucVu cv) {
        this.setMa(cv.getMa());
        this.setTen(cv.getTen());
    }

}
