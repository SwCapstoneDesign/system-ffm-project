package kr.co.ffm.system.admin;

import kr.co.ffm.system.farmedfish.FarmedFish;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    public Admin select(Admin admin);
}
