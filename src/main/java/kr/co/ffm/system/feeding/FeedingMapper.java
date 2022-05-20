package kr.co.ffm.system.feeding;

import kr.co.ffm.system.watertank.Watertank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedingMapper {
    public void insert(Feeding feeding);
    public List<Feeding> selectAll(Watertank watertank);
}
