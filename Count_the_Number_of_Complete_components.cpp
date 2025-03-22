class Solution {
public:

    void DFS(int s,vector<vector<int>> &adjlist, vector<int> &visited,unordered_set<int>&component)
    {
         if(!visited[s])
         {
             visited[s]=1;
             component.insert(s);
         }

         for(auto v : adjlist[s])
         {
              if(!visited[v])
              {
                   DFS(v,adjlist,visited,component);
              }
         }


    }
    int countCompleteComponents(int n, vector<vector<int>>& edges) {


       vector<vector<int>> AdjL (n);

       for(int i=0;i<edges.size();i++)
       { 
            int v1 = edges[i][0];
            int v2= edges[i][1];

            AdjL[v1].push_back(v2);
            AdjL[v2].push_back(v1);
         
       }



       vector<int> vis (n,0);
   
     
        int ans = 0;

       for(int i=0;i<n;i++)
       {
          
            if(vis[i]==0)
            {   
                unordered_set<int> comps;
                DFS(i,AdjL,vis,comps);

                bool complete = true;
                int  nodecount = comps.size();


                for(auto v : comps)
                {
                     if(AdjL[v].size() != nodecount-1 )
                     {
                         complete = false;
                         break;
                     }
                }

                if(complete)
                  ans++;
            }
             
           
 
       }


        return ans;
        
    }
};
