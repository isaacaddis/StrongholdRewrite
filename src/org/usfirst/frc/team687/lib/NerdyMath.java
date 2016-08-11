package org.usfirst.frc.team687.lib;
/*
 * Common, reusable functions for common calculations
 * 
 * @author Isaac
 */
public class NerdyMath {
	
    public static double radsToDeg(double deg)	{
    	return deg * 360 / (2 * Math.PI);
    }
    public static double degToRads(double rads)	{
    	return rads * (2 * Math.PI) / 360;
    }
    /*
     * @return make sure the value doesn't exceed max or go below min
     */
    public static double threshold(double val, double min, double max)	{
    	return Math.min(max, Math.max(min, val));
    }
    /*
     * Not my function! But thank you Team 687!
     */
	public static double normalizer(double rotPow, double maxPow){
		double higherPow = maxPow + rotPow;
		double lowerPow = maxPow - rotPow;
		
		return lowerPow/higherPow;
	}
	
}
