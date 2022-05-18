package kr.co.ffm.system.feeding;

import lombok.Data;

@Data
public class Feeding {
    private int no;
    private String waterTankId;
    private int feedingAmount;
    private String feedingTime;
}
