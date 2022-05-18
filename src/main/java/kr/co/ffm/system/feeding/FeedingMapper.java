package kr.co.ffm.system.feeding;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedingMapper {
    public void insert(Feeding feeding);
    public List<Feeding> selectAll(Feeding feeding);
}
