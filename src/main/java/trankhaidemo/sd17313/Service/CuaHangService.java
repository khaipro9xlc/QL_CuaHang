package trankhaidemo.sd17313.Service;

import org.springframework.stereotype.Service;
import trankhaidemo.sd17313.Domain.CuaHang;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CuaHangService {
    List<CuaHang> lstch = new ArrayList<>();

    public CuaHangService() {

    }


    public List<CuaHang> lst() {

        return lstch;
    }

    public void add(CuaHang cuaHang) {
        lstch.add(cuaHang);
    }

    public void update(CuaHang cuaHang, String ma) {
        for (int i = 0; i < lstch.size(); i++) {
            if (lstch.get(i).getMa().contains(ma)) {
                lstch.set(i, cuaHang);
            }
        }
    }

    public CuaHang Detail(String ma) {
        for (CuaHang ch : lstch) {
            if (ch.getMa().equals(ma)) {
                return ch;
            }
        }
        return null;
    }

    public void Delete(String ma) {
        CuaHang ch = Detail(ma);
        lstch.remove(ch);
    }


}
