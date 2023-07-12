package trankhaidemo.sd17313.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class HoaDonChiTietId implements Serializable {

    @Column(name = "IdHoaDon")
    private UUID IdHoaDon;
    @Column(name = "IdChiTietSP")
    private UUID IdChiTietSP;

}
