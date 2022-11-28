class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        
        //check for the nearest last small element
        //both left and right same in array
        //store the small element make a stack
        Stack<Integer> st=new Stack<>();
        int []left=new int[n];
        int []right=new int[n];
        
        //for left array
        for(int i=0;i<n;i++){
            if(st.isEmpty()) 
                left[i]=-1;
            else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
                if(st.isEmpty()) left[i]=-1;
                else left[i]=st.peek();
            }
           st.push(i);     
        }
        st.clear();
        
        //for right array
        for(int i=n-1;i>-1;i--){
            if(st.isEmpty()) 
                right[i]=n;
            else{
                while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
                if(st.isEmpty()) right[i]=n;
                else right[i]=st.peek();
            }
           st.push(i);     
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,arr[i]*(Math.abs(right[i]-left[i])-1));
        }
        return ans;
    }
}