package demo;

public class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       
        ListNode headL1 = l1;
        ListNode headL2 = l2;
        
        int cntX = 0;
        
        int x = 0;
        int y = 0;
        
        boolean keta = false;
        
        int ans[] = new int[100];
        
        if(headL1 == null && headL2 == null){
            return new ListNode(0);
        }
        
        while(headL1 != null || headL2 != null){
            
            if(headL1 == null){
                x = 0;
            }else{
                x = headL1.val;
                headL1 = headL1.next;
            };
            
            if(headL2 == null){
                y = 0;
            }else{
                y = headL2.val;
                headL2 = headL2.next;    
            };
            
            int val = 0;
            if(keta){
                val += 1;
            }
            
            if(((x + y + val) / 10) > 0){
                keta = true;
                val = (x + y + val) % 10;
            }else{
                keta = false;
                val +=  x + y;
            };
            
            ans[cntX] = val;
                                    
            cntX++;
        }
        
        ListNode ansNode;
        
        if(keta){
            ans[cntX] = 1;
            ansNode = new ListNode(ans[cntX--]);
        }else{
            cntX--;
            ansNode = new ListNode(ans[cntX--]);
        }
                
        while(cntX >= 0){
            ansNode = new ListNode(ans[cntX],ansNode);
            cntX--;
        }
        
        return ansNode;
        
    }
}
