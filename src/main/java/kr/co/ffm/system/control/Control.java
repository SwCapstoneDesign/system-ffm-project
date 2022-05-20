package kr.co.ffm.system.control;

import lombok.Data;

@Data
public class Control {
    private String control;
    private String action;
    private String target;
    private double value;
}
