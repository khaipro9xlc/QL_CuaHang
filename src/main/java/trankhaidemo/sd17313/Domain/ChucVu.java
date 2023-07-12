package trankhaidemo.sd17313.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.ViewModel.ChucVuVm;
import trankhaidemo.sd17313.ViewModel.DongSpVm;

import java.util.List;
import java.util.UUID;

@Component
@Entity
@Table(name = "ChucVu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChucVu {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;
    @OneToMany(mappedBy = "chucVu")
    List<NhanVien> lstnv;

    public void loadFromViewModel(ChucVuVm cvvm) {
        this.setMa(cvvm.getMa());
        this.setTen(cvvm.getTen());
    }
}
