// my solution -- TLE
class Solution {
    public boolean isSelfCrossing(int[] distance) {
        HashSet<String> set = new HashSet<>();
        long x = 0;
        long y = 0;
        set.add(Long.toString(x) + "-" + Long.toString(y));
        
        int[] xDir = {0, -1, 0, 1};
        int[] yDir = {1, 0, -1, 0};
        
        for (int i = 0; i < distance.length; i++) {
            for (int j = 1; j <= distance[i]; j++) {
                x = x + xDir[i%4];
                y = y + yDir[i%4];
                String pos = Long.toString(x) + "-" + Long.toString(y);
                if (set.contains(pos)) return true;
                else set.add(pos);
            }
        }
        return false;
    }
}

// better solution
class Solution {
	public boolean isSelfCrossing(int[] distance) {
		for(int i=3;i<distance.length;i++){
			if(distance[i]>=distance[i-2] && distance[i-1]<=distance[i-3])  return true;
			if(i>=4 && distance[i]+distance[i-4]>=distance[i-2] && 
			   distance[i-1]==distance[i-3]) return true;
			if(i>=5 && distance[i-2]>=distance[i-4] && distance[i]+distance[i-4]>=distance[i-2] && 
			   distance[i-1]<=distance[i-3] && distance[i-1]+distance[i-5]>=distance[i-3]) return true;
		}
		return false;
	}
}
