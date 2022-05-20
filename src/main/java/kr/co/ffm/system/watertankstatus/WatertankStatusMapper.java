package kr.co.ffm.system.watertankstatus;

import kr.co.ffm.system.page.Page;
import kr.co.ffm.system.watertank.Watertank;
import kr.co.ffm.system.watertank.WatertankViewInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WatertankStatusMapper {
    public void insert(WatertankStatus watertankStatus);
    public List<WatertankStatus> selectAllByRownum(Page page);
    public List<WatertankStatus> selectAllByWatertankId(WatertankStatus watertankStatus);
}
