package kr.co.ffm.system.farmedfish;

import lombok.Data;

@Data
public class FarmedFish {
    private int no;
    private String name;
    private double temperature;
    private double ph;
    private double oxygen;
    private String feedingTime;
    private int feedingAmount;
    private String active;
}
