class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
	Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer i1, Integer i2) {
			if (username[i1].compareTo(username[i2]) == 0) { // Belongs to the same user
				return timestamp[i1] - timestamp[i2]; // Compare by timestamps
			}
			return username[i1].compareTo(username[i2]); // Otherwise compare by users
		}
	};

	String ans = null;
	Integer[] idArr = new Integer[username.length]; // Store the sorted ids
	for (int i = 0; i < idArr.length; i++) idArr[i] = i;
	Arrays.sort(idArr, comp);
	Map<String, Integer> score = new HashMap<>();
	Set<String> set = new HashSet<>(); // avoiding duplicates from the same user
	int count = 0;
	for (int i = 0; i < idArr.length; i++) {
		// New user we can clear the user patterns
		if (i != 0 && !username[idArr[i - 1]].equals(username[idArr[i]])) set.clear();
		for (int j = i + 1; j < idArr.length; j++) {
			for (int k = j + 1; k < idArr.length; k++) {
				if (username[idArr[i]].compareTo(username[idArr[j]]) == 0 
					&& username[idArr[i]].compareTo(username[idArr[k]]) == 0) {
					StringBuilder sb = new StringBuilder();
					sb.append(website[idArr[i]]).append(",").append(website[idArr[j]]).append(",").append(website[idArr[k]]);
					String key = sb.toString();
					if(!set.contains(key)) score.put(key, score.getOrDefault(key, 0) + 1);
					set.add(key);

					Integer ansScore = score.get(ans); // can be null
					int keyScore = score.get(key);
					// Store the key if the score is higher or if the score is the same then check for the lexicographically smaller
					if (ans == null || ansScore < keyScore || (ansScore == keyScore && key.compareTo(ans) < 0)) {
						ans = key;
					}
				}

			}
		}
	}
	List<String> res = new ArrayList<>();
	String[] ansArr = ans.split(",");
	for (String s : ansArr) {
		res.add(s);
	}

	return res;
    }
}