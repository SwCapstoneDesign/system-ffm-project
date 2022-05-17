package kr.co.ffm.system.farmedfish;

import lombok.Data;

@Data
public class FarmedFish {
    private int no;
    private String name;
    private int temperature;
    private int PH;
    private int oxygen;
    private String feedingTime;
    private int feedingAmount;
    private char active;
}
