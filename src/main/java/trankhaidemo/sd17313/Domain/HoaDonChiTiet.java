package trankhaidemo.sd17313.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@IdClass(HoaDonChiTietId.class)
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {

    @Id
//    @ManyToOne
//    @JoinColumn(name = "IdHoaDon")
    @Column(name = "IdHoaDon")
    private UUID IdHoaDon;

    @Id
//    @ManyToOne
//    @JoinColumn(name = "IdChiTietSP")
    @Column(name = "IdChiTietSP")
    private UUID IdChiTietSP;

    @Column(name = "SoLuong")
    private int SoLuong;
    @Column(name = "DonGia")
    private BigDecimal DonGia;

}
