package kr.co.ffm.system.farmedfish;

import lombok.Data;

@Data
public class FarmedFish {
    private int no;
    private String name;
    private int temperature;
    private int ph;
    private int oxygen;
    private String feedingTime;
    private int feedingAmount;
    private String active;
}
