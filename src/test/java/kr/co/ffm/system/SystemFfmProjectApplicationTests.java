package kr.co.ffm.system;

import kr.co.ffm.system.admin.AdminController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class SystemFfmProjectApplicationTests {
    @Autowired
    private AdminController adminController;
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @DisplayName("adminController Test")
    @Test
    void adminControllerTest() {

    }
}
