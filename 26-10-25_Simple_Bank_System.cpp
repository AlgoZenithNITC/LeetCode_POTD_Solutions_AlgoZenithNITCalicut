class Bank {
    vector<long long> balance;
    int n;
public:
    Bank(vector<long long>& balance) {
        this->balance = balance;
        n = balance.size();
    }
    
    bool transfer(int account1, int account2, long long money) {
        if (!(account1 >= 1 && account1 <= n && account2 >= 1 && account2 <= n)) 
            return false;
        if (this->balance[account1 - 1] < money)
            return false;

        this->balance[account2 - 1] += money;
        this->balance[account1 - 1] -= money;
        return true;
    }
    
    bool deposit(int account, long long money) {
        if (!(account >= 1 && account <= n)) 
            return false;

        this->balance[account - 1] += money;
        return true;
    }
    
    bool withdraw(int account, long long money) {
        if (!(account >= 1 && account <= n)) 
            return false;
        if (this->balance[account - 1] < money)
            return false;

        this->balance[account - 1] -= money;
        return true;
    }
};
