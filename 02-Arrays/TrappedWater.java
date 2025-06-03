public class TrappedWater {

    public static int TrappedWater(int heights[]){
        int n = heights.length;

        //find left max boundary
        int leftmax[] = new int[n];
        leftmax[0] = heights[0];  //corner cases
        
        for(int i =1;i<n;i++){
            leftmax[i] = Math.max(heights[i],leftmax[i-1]);
        }

        //find right max boundary
        int rightmax[] = new int[n];
        rightmax[n-1] = heights[n-1];  //corner cases

        for(int i = n-2;i>=0;i--){
            rightmax[i] = Math.max(heights[i],rightmax[i+1]);
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
