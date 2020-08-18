//Time - O(n)
//Space - O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks==null || tasks.length==0)
            return 0;
        int maxFreq = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(Character task:tasks){
            int currCount = map.getOrDefault(task,0);
            map.put(task,currCount+1);
            maxFreq = Math.max(maxFreq,map.get(task));
        }
        
        int maxCount = 0;
        for(Map.Entry<Character,Integer> m : map.entrySet()){
            if(m.getValue()==maxFreq)
                maxCount++;
        }
        
        int part = maxFreq - 1;
        int empty = (n-(maxCount-1))*part;
        int remaining = tasks.length - maxFreq*maxCount;
        int idle = Math.max(0,empty-remaining);
        return idle+tasks.length;
    }
}
