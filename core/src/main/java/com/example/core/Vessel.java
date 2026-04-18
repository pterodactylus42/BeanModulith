package com.example.core;

import com.example.shared.CourseUnit;
import com.example.shared.Direction;
import com.example.shared.SpeedUnit;

public class Vessel {
    public static Direction course = Direction.N;
    public static double speed = 0d;
    public static SpeedUnit speedUnit() {
        return SpeedUnit.KNOTS;
    }
    public static CourseUnit courseUnit() { return CourseUnit.DEGREES; }

}
