Node* replaceWithCousinsSum(Node* root) {
    if (!root) return nullptr;

    queue<QueueNode*> q;
    q.push(new QueueNode(root, nullptr, 0));

    while (!q.empty()) {
        int size = q.size();
        int levelSum = 0;

        for (int i = 0; i < size; ++i) {
            QueueNode* qNode = q.front();
            q.pop();
            levelSum += qNode->node->data;
            q.push(qNode);
        }

        for (int i = 0; i < size; ++i) {
            QueueNode* qNode = q.front();
            q.pop();
            Node* node = qNode->node;
            Node* parent = qNode->parent;

            int sumOfCousins = levelSum;

            if (parent && parent->left == node && parent->right) {
                sumOfCousins -= parent->right->data;
            }
            if (parent && parent->right == node && parent->left) {
                sumOfCousins -= parent->left->data;
            }

            sumOfCousins -= node->data;

            node->data = sumOfCousins;

            if (node->left) q.push(new QueueNode(node->left, node, qNode->level + 1));
            if (node->right) q.push(new QueueNode(node->right, node, qNode->level + 1));
        }
    }

    return root;
}
