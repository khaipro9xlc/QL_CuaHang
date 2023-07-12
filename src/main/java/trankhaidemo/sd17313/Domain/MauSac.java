package trankhaidemo.sd17313.Domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.ViewModel.MauSacVm;
import trankhaidemo.sd17313.ViewModel.SanPhamVm;

import java.io.Serializable;
import java.util.UUID;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "MauSac")
public class MauSac implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;

    public void loadFromViewModel(MauSacVm mauSacVm) {
        this.setMa(mauSacVm.getMa());
        this.setTen(mauSacVm.getTen());
    }
}
