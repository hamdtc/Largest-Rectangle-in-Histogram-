class Solution {
    public int largestRectangleArea(int[] arr) {
  
      for(int i=0;i<n;i++){
          int j=i;
          int k=i;
          for(;j<n;j++){
              if(arr[j]<arr[i]){
                  break;
              }
          }
          for(;k>-1;k--){
              if(arr[k]<arr[i]){
                  break;
              }
          }
          int out=(j-k-1)*arr[i];
          max=Math.max(max,out);
      }
        return max;
	}
}
