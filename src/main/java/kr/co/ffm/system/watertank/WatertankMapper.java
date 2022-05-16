package kr.co.ffm.system.watertank;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WatertankMapper {
    public void insert(Watertank watertank);
    public List<Watertank> selectAll(Watertank watertank);
    public Watertank selectById(Watertank watertank);
    public void updateById(Watertank watertank);
}
