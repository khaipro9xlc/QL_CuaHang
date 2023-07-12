package trankhaidemo.sd17313.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class GioHang {

    private List<GioHangChiTiet> lstGioHangChiTiets;
}
