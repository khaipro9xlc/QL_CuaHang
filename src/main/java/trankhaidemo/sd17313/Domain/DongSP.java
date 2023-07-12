package trankhaidemo.sd17313.Domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;
import trankhaidemo.sd17313.ViewModel.DongSpVm;


import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "DongSP")
public class DongSP implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(name = "Ma")
    private String Ma;
    @Column(name = "Ten")
    private String Ten;
    @OneToMany(mappedBy = "dsp")
    private List<ChiTietSP> listctsp;

    public void loadFromViewModel(DongSpVm vm) {
        this.setMa(vm.getMa());
        this.setTen(vm.getTen());
    }
}
