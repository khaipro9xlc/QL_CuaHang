package trankhaidemo.sd17313.cuaHangBeanConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import trankhaidemo.sd17313.ViewModel.NhanVienVm;

@Configuration
public class NhanVienBeanConfig {
    @Bean("nv1")
    public NhanVienVm getNV1() {
        NhanVienVm nv = new NhanVienVm();
        return nv;
    }
}
