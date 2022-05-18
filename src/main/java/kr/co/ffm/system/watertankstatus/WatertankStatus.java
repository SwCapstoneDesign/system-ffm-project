package kr.co.ffm.system.watertankstatus;

import lombok.Data;

@Data
public class WatertankStatus {
    private int no;
    private String watertankId;
    private double temperature;
    private double ph;
    private double oxygen;
    private String measureTime;
}