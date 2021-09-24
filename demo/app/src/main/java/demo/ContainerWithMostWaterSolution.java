package demo;

class ContainerWithMostWaterSolution {
    public int maxArea(int[] height) {
        
        int cnt = 0;
        // 現在、最も大きい面積
        int ansSize = 0;

        // 与えられた配列分の繰り返し処理
        for(int hgt : height){
            // 初回実行時または、hgtで得られる最大の面積がansSizeを超えている場合
            // *得られる最大の面積 = 高さ（hgt）*横（height.length - cnt)
            if(cnt == 0 || (ansSize < hgt * (height.length - cnt))){
                int temp = maxSize(height, hgt, cnt);
                if(temp > ansSize){
                    ansSize = temp;
                }

            }
            cnt++;          
        }

        return ansSize;
    }
    
    // 最も大きな面積を取得
    private int maxSize(int[] height, int tate, int head){

        int max = 0;
        // heightのリストをheadから繰り返す。
        for(int i = head; i < height.length; i++){
            // tateがheight[i]より小さい場合、tateを高さとして面積を取得する
            // ＊高さが低い方に合わせて面積を算出する必要があるため
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