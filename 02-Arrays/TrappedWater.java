public class TrappedWater {

    public static int TrappedWater(int heights[]){
        int n = heights.length;

        //find left max boundary
        int leftmax[] = new int[n];
        leftmax[0] = heights[0];  //corner cases
        
        for(int i =1;i<n;i++){
            leftmax[i] = Math.max(heights[i],leftmax[i-1]); //leftmax[i-1] cuz we are finding left max from current index  and (i-1) that will be the max. only because it is getting checked at every index for max
        }

        //find right max boundary
        int rightmax[] = new int[n];
        rightmax[n-1] = heights[n-1];  //corner cases

        for(int i = n-2;i>=0;i--){
            rightmax[i] = Math.max(heights[i],rightmax[i+1]); //height[i] is the current pos and rightmax[i+1] is for the highest building from that index to the right
        }

        //loop to find water level and trapped water

        int trappedwater = 0;
        for(int i = 0; i<n;i++){
            int waterlevel = Math.min(leftmax[i],rightmax[i]);  //imp
            trappedwater += waterlevel - heights[i];   //imp
        }
        return trappedwater;
    }
    public static void main(String[] args){
        int heights[] = {4,2,0,6,3,2,5};
        int result = TrappedWater(heights);
        System.out.print(result);
    }
        

}
