class Solution:
    def __init__(self):
        self.connected_component_count = 0

    def find_representative(self, element, set_representatives):
        if set_representatives[element] == 0:
            set_representatives[element] = element
            self.connected_component_count += 1
        return set_representatives[element] if set_representatives[element] == element else \
               (set_representatives[element] := self.find_representative(set_representatives[element], set_representatives))

    def merge_components(self, element_a, element_b, set_representatives):
        rep_a = self.find_representative(element_a, set_representatives)
        rep_b = self.find_representative(element_b, set_representatives)
        if rep_a != rep_b:
            set_representatives[rep_b] = rep_a
            self.connected_component_count -= 1

    def remove_stones(self, stone_positions):
        set_representatives = [0] * 20003
        for stone_position in stone_positions:
            self.merge_components(stone_position[0] + 1, stone_position[1] + 10002, set_representatives)
        return len(stone_positions) - self.connected_component_count

