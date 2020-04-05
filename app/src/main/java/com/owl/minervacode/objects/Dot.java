package com.owl.minervacode.objects;

public class Dot
{
    private final float centerRadius;
    private final double length;



    public Dot(double length, float centerRadius)
    {
        this.centerRadius = centerRadius;
        this.length = length;
    }

    public float getCenterRadius()
    {
        return centerRadius;
    }

    public double getLength()
    {
        return length;
    }
}