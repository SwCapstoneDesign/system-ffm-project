package kr.co.ffm.system.watertank;

import lombok.Data;

@Data
public class Watertank {
    private String id;
    private int farmedFishNo;
    private String agentIpAddress;
    private String registDate;
    private String active;
    private int no;
    private String watertankId;
    private int temperature;
    private int ph;
    private int oxygen;
    private String measureTime;
}
