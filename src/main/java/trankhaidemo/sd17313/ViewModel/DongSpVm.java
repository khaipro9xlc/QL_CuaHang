package trankhaidemo.sd17313.ViewModel;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.Domain.DongSP;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DongSpVm {

    @NotBlank(message = "Không được để trống")
    private String ma;
    @NotBlank(message = "Không được để trống")
    private String ten;

    public void loadFromDomainModel(DongSP dsp) {
        this.setMa(dsp.getMa());
        this.setTen(dsp.getTen());
    }

}
