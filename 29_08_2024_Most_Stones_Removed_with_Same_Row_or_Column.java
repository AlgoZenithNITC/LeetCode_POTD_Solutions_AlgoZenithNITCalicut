import java.util.List;
import java.util.ArrayList;

class Solution {
    private int connectedComponentCount = 0;

    private int findRepresentative(int element, int[] setRepresentatives) {
        if (setRepresentatives[element] == 0) {
            setRepresentatives[element] = element;
            connectedComponentCount++;
        }
        return setRepresentatives[element] == element ? element : 
               (setRepresentatives[element] = findRepresentative(setRepresentatives[element], setRepresentatives));
    }

    private void mergeComponents(int elementA, int elementB, int[] setRepresentatives) {
        int repA = findRepresentative(elementA, setRepresentatives);
        int repB = findRepresentative(elementB, setRepresentatives);
        if (repA != repB) {
            setRepresentatives[repB] = repA;
            connectedComponentCount--;
        }
    }

    public int removeStones(List<List<Integer>> stonePositions) {
        int[] setRepresentatives = new int[20003];
        for (List<Integer> stonePosition : stonePositions) {
            mergeComponents(stonePosition.get(0) + 1, stonePosition.get(1) + 10002, setRepresentatives);
        }
        return stonePositions.size() - connectedComponentCount;
    }
}

