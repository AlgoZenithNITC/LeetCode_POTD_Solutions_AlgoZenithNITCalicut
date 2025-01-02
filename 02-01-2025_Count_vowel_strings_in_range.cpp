bool search(string &s){
    vector<char> vowels = {'a', 'e', 'i', 'o', 'u'};

    int l = 0;
    for(char ch: vowels){
        if(s[0] == ch){
            l = 1;
            break;
        }
    }

    int r = 0;
    for(char ch: vowels){
        if(s[s.length()-1] == ch){
            r = 1;
            break;
        }
    }

    return l&r;
}

vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
    int n = words.size();

    vector<int> binary(n, 0);

    for(int i = 0; i < n; i++){
        string s = words[i];
        if(search(s))
            binary[i] = 1;
    }

    for(int i = 1; i < n; i++){
        binary[i] += binary[i-1];
    }

    vector<int> ans;

    for(vector<int> query: queries){
        int l = query[0];
        int r = query[1];

        l--;

        int temp;

        if(l < 0)
            temp = binary[r];
        else
            temp = binary[r] - binary[l];

        ans.push_back(temp);   
    }

    return ans;
}
