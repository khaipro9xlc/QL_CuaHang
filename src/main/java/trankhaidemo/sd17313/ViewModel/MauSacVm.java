package trankhaidemo.sd17313.ViewModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.Domain.MauSac;
import trankhaidemo.sd17313.Domain.SanPham;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MauSacVm {
    private String ma;
    private String ten;

    public void loadFromDomainModel(MauSac mauSac) {
        this.setMa(mauSac.getMa());
        this.setTen(mauSac.getTen());
    }

}
