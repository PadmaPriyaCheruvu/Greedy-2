//Time - O(n)
//Space - O(n)
class Solution {
    public int candy(int[] ratings) {
        if(ratings==null|| ratings.length==0)
            return 0;
        int ans = 0;
        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1])
           { candy[i] = candy[i-1]+1;}
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candy[i] = Math.max(candy[i],candy[i+1]+1);
            }
        }
        for(int i=0;i<ratings.length;i++){
            ans+=candy[i];
        }
        return ans;
    }
}
