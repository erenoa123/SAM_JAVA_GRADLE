package demo;

public class ContainerWithMostWaterSolution {
    public int maxArea(int[] height) {
        
        int cnt = 0;
        int ansSize = 0;
        // int ansHeight =  0;
        // int ansCnt = 0;
        // int maxHeight = 0;

        for(int hgt : height){
            if(cnt == 0 || (ansSize < hgt * (height.length - cnt))){
                int temp = maxSize(height, hgt, cnt);
                if(temp > ansSize){
                    ansSize = temp;
                }

            }
            // if(cnt == 0 || ((hgt - ansHeight) - (cnt - ansCnt)) > 0){
            //     int temp = maxSize(height, hgt, cnt);
            //     if(temp > ansSize){
            //         ansSize = temp;
            //     }
            //     ansHeight = hgt;
            //     ansCnt = cnt;
            // }
            // if(maxHeight < hgt){
            //     maxHeight = hgt;
            // }
            // if((maxHeight > height.length/2) && cnt > height.length/2){
            //     break;
            // }
            cnt++;          
        }

        return ansSize;
    }

    private int maxSize(int[] height, int tate, int head){

        int max = 0;
        for(int i = head; i < height.length; i++){
            if(tate < height[i]){
                if((tate * (i - head)) > max){
                    max = tate * (i - head);
                }
            }else{
                if((height[i] * (i - head)) > max){
                    max = height[i] * (i - head);
                }
                    
            }
        }

        return max;

    }
}
