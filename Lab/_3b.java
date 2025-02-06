package Lab;

public class _3b {
    static void trapWater(int[] height, int si){
        int left=0, right=si-1;
        int leftMax=0; int rightMax=0;
        int water =0;

        while(left<=right){
            if(height[left]< height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }
                else{
                    water =water+ leftMax-height[left];
                }
                left++;
            }
            else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }
                else{
                    water+= rightMax-height[right];
                }
                right--;
            }
        }
        System.out.println(water);
    }
    public static void main(String[] args) {
        int[] a = {3,0,0,2,0,4};
        trapWater(a, a.length);
    }
}
