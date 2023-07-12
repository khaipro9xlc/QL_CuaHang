package trankhaidemo.sd17313.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.ViewModel.ChucVuVm;
import trankhaidemo.sd17313.ViewModel.SanPhamVm;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Component

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(name = "Ma")
    private String Ma;
    @Column(name = "Ten")
    private String Ten;
    @OneToMany(mappedBy = "sp")
    private List<ChiTietSP> listctsp;

    public void loadFromViewModel(SanPhamVm sanPhamVm) {
        this.setMa(sanPhamVm.getMa());
        this.setTen(sanPhamVm.getTen());
    }
}
