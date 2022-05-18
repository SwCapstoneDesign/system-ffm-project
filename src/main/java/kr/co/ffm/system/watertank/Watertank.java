package kr.co.ffm.system.watertank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Watertank {
    private String id;
    private int farmedFishNo;
    private String farmedFishName;
    private String agentIpAddress;
    private String registDate;
    private String active;
}
