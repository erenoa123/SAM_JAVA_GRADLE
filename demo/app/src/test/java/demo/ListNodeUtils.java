package demo;

public class ListNodeUtils {
    
    static public ListNode make(int[] vals){

        ListNode tmp = new ListNode();
        ListNode ret = tmp;
        ListNode prv = new ListNode();
        
        for(int v : vals){
            ListNode node = new ListNode();
            tmp.val = v;
            tmp.next = node;
            prv = tmp;
            tmp = node;
        }
        prv.next = null;

        return ret;
    }

    static public boolean assertListNode(ListNode vals, ListNode exp){

        while(vals != null || exp != null){
            System.out.println("val :" + vals.val);
            System.out.println("exp :" + exp.val);
            if(vals == null || exp == null){
                return false;
            }
            if(vals.val == exp.val){
                vals = vals.next;
                exp = exp.next;
            }else{
                return false;
            }
        }

        return true;
    }

}
