package kr.co.ffm.system;

import kr.co.ffm.system.admin.Admin;
import kr.co.ffm.system.admin.AdminMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

public class DatabaseTest {
    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void adminTest() {
        Admin admin = new Admin();
        admin.setId("admin");

        Admin adm = adminMapper.select(admin);

        Assertions.assertThat(adm.getId()).isEqualTo("admin");
    }
}
