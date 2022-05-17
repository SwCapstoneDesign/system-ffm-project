package kr.co.ffm.system.farmedfish;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FarmedFishMapper {
    public void insert(FarmedFish farmedFish);
    public List<FarmedFish> selectAll();
    public FarmedFish selectByNo(FarmedFish farmedFish);
    public void updateByNo(FarmedFish farmedFish);
}
