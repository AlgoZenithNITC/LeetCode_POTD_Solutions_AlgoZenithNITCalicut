class Solution {
    public List<String> removeSubfolders(String[] folder) 
    { 

          Arrays.sort(folder); 

        List<String> res = new ArrayList<>();

        for (String path : folder) {
            if (res.isEmpty() || !path.startsWith(res.get(res.size() - 1) + "/")) {
                res.add(path);
            }
        }

        return res;

    }
}
