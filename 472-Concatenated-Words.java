class Solution {
    Set<String> set = new HashSet<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        for (String word : words) {
            set.add(word);
        }

        List<String> ans = new ArrayList<>();

        for (String word : words) {
            set.remove(word);

            Boolean[] dp = new Boolean[word.length() + 1];

            if (dfs(word, 0, dp)) {
                ans.add(word);
            }

            set.add(word);
        }

        return ans;
    }

    boolean dfs(String word, int idx, Boolean[] dp) {

        if (idx == word.length())
            return true;

        if (dp[idx] != null)
            return dp[idx];

        for (int i = idx; i < word.length(); i++) {

            String part = word.substring(idx, i + 1);

            if (set.contains(part) && dfs(word, i + 1, dp)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}