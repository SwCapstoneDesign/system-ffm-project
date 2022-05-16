package kr.co.ffm.system.watertank;

import lombok.Data;

@Data
public class WatertankViewInfo {
    private String id;
    private int farmedFishNo;
    private String agentIpAddress;
    private String registDate;
    private String active;
}
