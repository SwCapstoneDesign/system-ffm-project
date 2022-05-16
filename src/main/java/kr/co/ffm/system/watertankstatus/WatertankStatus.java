package kr.co.ffm.system.watertankstatus;

import lombok.Data;

@Data
public class WatertankStatus {
    private int no;
    private String watertankId;
    private int temperature;
    private int ph;
    private int oxygen;
    private String measureTime;
}