// Question
// Given a String S consisting only lowercase alphabets and an integer K. Find the count of all substrings of length K which have exactly K-1 distinct characters.
// Input:
// S = "abcc"
// K = 2
// Output:
// 1

int countOfSubstrings(string S, int K) {
        
        int i=0 , j =0 ;
        
        map<char,int> mp ; 
        
        int count= 0 ;
        while(j<S.length())
        {
            mp[S[j]]++ ;
            
            if(j-i+1<K)
            {
                j++ ;
            }
            else 
            {   
                if(mp.size()==K-1)
                {
                    count++ ;
                }
                mp[S[i]]-- ;
                if(mp[S[i]]==0)
                {
                    mp.erase(S[i]) ;
                }
                
                i++ ;
                j++ ;
            }
        }
        
        return count ;
    }
