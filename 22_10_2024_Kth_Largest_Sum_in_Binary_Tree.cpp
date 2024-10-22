class Solution {
public:
    long long kthLargestLevelSum(TreeNode* root, int k) {
        vector <long long int> sums = LevelOrder(root);

        sort(sums.begin(),sums.end());

        if(k>sums.size())
        {
            return -1;
        }

        return sums.at(sums.size()-k);
    }

void Enqueue(struct TreeNode * Q[],int * frontptr,int * rearptr,int n,struct TreeNode * node)
{ 
   if(*rearptr==n-1)
   {
      return;
   }

   else if(*rearptr==-1 && *frontptr==-1)
   {
      (*frontptr)++;
      (*rearptr)++;

      Q[*rearptr]=node;
   }

   else
   {
       
       (*rearptr)++;
      Q[*rearptr]=node;
   }

}

struct TreeNode * Dequeue(struct TreeNode * Q[],int * frontptr,int * rearptr,int n)
{
    if(*frontptr==-1)
    {
        return NULL;
    }
    
    else if(*frontptr==*rearptr)
    {
        struct TreeNode * removed = Q[*frontptr];
        (*frontptr)=-1;
        *rearptr=-1;
        return removed;
    }

    else
    {
        struct TreeNode * removed = Q[*frontptr];
        (*frontptr)++;
        return removed;
    }
}

vector < long long int> LevelOrder(TreeNode * root)
{
    vector<long long int> sums;

    int front=-1;
    int rear = -1;

    int n=100000;

    struct TreeNode * Q[n];
    
    Enqueue(Q,&front,&rear,n,root);

    while(front!=-1) //Queue Not Empty
    {
        int levelsize=rear-front+1; //number of elements enqueued at a time will be elements at that level 
        long long int levelsum=0;   //add that to the sum until we finish adding the next level, while traversing current level
        
        while(levelsize>0)
        {
            struct TreeNode* node = Dequeue(Q,&front,&rear,n);

            levelsum+=node->val;

            if(node->left!=NULL)
            {
                Enqueue(Q,&front,&rear,n,node->left);
            }    

             if(node->right!=NULL)
            {
                Enqueue(Q,&front,&rear,n,node->right);
            }  

            levelsize=levelsize-1; //finished 1 element of the level
        }
       
        sums.push_back(levelsum);
    
    }


   return sums;
}

};
