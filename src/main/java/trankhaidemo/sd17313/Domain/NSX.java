package trankhaidemo.sd17313.Domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.ViewModel.NSXVm;
import trankhaidemo.sd17313.ViewModel.SanPhamVm;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "NSX")
public class NSX {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "nsx")
    private List<ChiTietSP> listctsp;

    public void loadFromViewModel(NSXVm nsxVm) {
        this.setMa(nsxVm.getMa());
        this.setTen(nsxVm.getTen());
    }
}
