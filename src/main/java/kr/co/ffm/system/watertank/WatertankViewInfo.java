package kr.co.ffm.system.watertank;

import kr.co.ffm.system.farmedfish.FarmedFish;
import kr.co.ffm.system.watertankstatus.WatertankStatus;
import lombok.Data;

import java.util.List;

@Data
public class WatertankViewInfo {
    private String id;
    private int farmedFishNo;
    private String farmedFishName;
    private String agentIpAddress;
    private String registDate;
    private String active;
    private List<WatertankStatus> statusList;
}
