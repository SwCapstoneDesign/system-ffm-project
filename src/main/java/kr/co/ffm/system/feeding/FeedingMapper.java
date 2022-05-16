package kr.co.ffm.system.feeding;

import java.util.List;

public interface FeedingMapper {
    public void insert(Feeding feeding);
    public List<Feeding> selectAll(Feeding feeding);
}
