from typing import List

class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        # Sort the folder array
        folder.sort()
        
        # List to store root folders
        rootsFolder = [folder[0]]  # Add the first folder as a root

        # Iterate through the sorted folder list
        for i in range(1, len(folder)):
            lastRoot = rootsFolder[-1]  # Get the last added root folder
            # Check if the current folder is not a subfolder of the last added root
            if not folder[i].startswith(lastRoot) or folder[i][len(lastRoot)] != '/':
                rootsFolder.append(folder[i])  # Add to rootsFolder

        return rootsFolder  # Return the resulting list of strings
