import java.util.*;
class minimumWindowSubstring {
    public boolean equals(HashMap<Character,Integer> m,HashMap<Character,Integer> m1){
        for(Character c : m1.keySet()){
            if(m1.get(c)>m.getOrDefault(c,0)){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        HashMap<Character,Integer> m1= new HashMap<>();
        for(char c: t.toCharArray()){
            m1.put(c,m1.getOrDefault(c,0)+1);
        }
        HashMap<Character,Integer> m= new HashMap<>();
        for(char c: t.toCharArray()){
            m.put(c,0);
        }
        int i=0;
        int maxy=s.length();
        String ss="";
        boolean flag=false;
        for(int j=0;j<s.length();j++){
            char curr=s.charAt(j);
            m.put(curr,m.getOrDefault(curr,0)+1);
            System.out.println(m);
            while(equals(m,m1)){
                flag=true;
                char cur=s.charAt(i);
                m.put(cur,m.getOrDefault(cur,0)-1);
                if(m.get(cur)==0){
                    m.remove(cur);
                }
                i++;
            }
            if(maxy>(j-i) && flag){
                maxy=j-i;
                if(i>0){
                    ss=s.substring(i-1,j+1);
                }
                flag=false;
            }
        }
        return ss;
    }
}