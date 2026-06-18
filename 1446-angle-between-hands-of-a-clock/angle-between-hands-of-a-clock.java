class Solution {
    public double angleClock(int hour, int minutes) {
        double minangl = minutes * 6;
        double hourangl;
        if(hour == 12){
            hourangl =  (((double)minutes) / 2);
        }else{
            hourangl = ( hour * 30 ) + (((double)minutes) / 2);
        }
        double a = Math.abs(minangl - hourangl);
        return Math.min(a,360-a);
    }
}