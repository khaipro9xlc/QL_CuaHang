package trankhaidemo.sd17313.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GioHangChiTiet {
    private UUID idSP;
    private String tenSP;
    private Integer soLuong;
    private BigDecimal price;

}
