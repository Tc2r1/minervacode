package com.owl.minervacode.objects;

public class Arc
{
    private final float centerRadius;
    private final double startAngle;
    private final double endAngle;



    public Arc(float centerRadius, double startAngle, double endAngle)
    {
        this.centerRadius = centerRadius;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
    }

    public float getCenterRadius()
    {
        return centerRadius;
    }

    public double getStartAngle()
    {
        return startAngle;
    }

    public double getEndAngle()
    {
        return endAngle;
    }
}