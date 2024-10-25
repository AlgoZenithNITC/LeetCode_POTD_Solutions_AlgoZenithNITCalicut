import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folder array
        Arrays.sort(folder);
        
        // List to store root folders
        List<String> rootsFolder = new ArrayList<>();
        rootsFolder.add(folder[0]); // Add the first folder as a root

        // Iterate through the sorted folder list
        for (int i = 1; i < folder.length; i++) {
            String lastRoot = rootsFolder.get(rootsFolder.size() - 1);
            // Check if the current folder is not a subfolder of the last added root
            if (!folder[i].startsWith(lastRoot) || 
                folder[i].charAt(lastRoot.length()) != '/') {
                rootsFolder.add(folder[i]); // Add to rootsFolder
            }
        }

        return rootsFolder; // Return the resulting list of strings
    }
}
