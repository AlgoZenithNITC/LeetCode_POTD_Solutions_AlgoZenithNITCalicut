#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

class Solution {
public:
    std::vector<std::string> removeSubfolders(std::vector<std::string>& folder) {
        std::sort(folder.begin(), folder.end());
        std::vector<std::string> rootsFolder;
        rootsFolder.push_back(folder[0]);

        for (size_t i = 1; i < folder.size(); i++) {
            const std::string& lastRoot = rootsFolder.back();
            if (folder[i].compare(0, lastRoot.size(), lastRoot) != 0 || 
                folder[i][lastRoot.size()] != '/') {
                rootsFolder.push_back(folder[i]);
            }
        }

        return rootsFolder; 
    }
};
