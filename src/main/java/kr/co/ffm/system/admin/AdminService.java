package kr.co.ffm.system.admin;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    public boolean login(Admin admin);
}
