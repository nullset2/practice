class Trie{
    static final int ALPHABET_SIZE = 26; //assuming ascii english for now

    static class Node{
        Node[] children = new Node[ALPHABET_SIZE];
        boolean isLeaf;

        Node(){
            isLeaf = false;
            for(int i = 0; i < ALPHABET_SIZE; i++){
                children[i] = null;
            }
        }
    }
    
    static Node root;

    static void insert(String key){
        int level;
        int length = key.length();
        int index;

        Node pCrawl = root;

        for(level = 0; level < length; level++){
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null)
                pCrawl.children[index] = new Node();

            pCrawl = pCrawl.children[index];
        }

        pCrawl.isLeaf = true;
    }

    static boolean search(String key){
        int level;
        int length = key.length();
        int index;
        Node pCrawl = root;
        
        for(level = 0; level < length; level++){
            index = key.charAt(level) - 'a';

            if(pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isLeaf);
    }

    public static void main(String[] args){
        String[] keys = {"the", "a", "there", "then", "theodore", "answer", "any", "by", "bye", "their"};
        String[] toFind = {"the", "there", "that", "asgore"};

        root = new Node();

        for(int i = 0; i < keys.length; i++){
            insert(keys[i]);
        }

        for(int i = 0; i < toFind.length; i++){
            if(search(toFind[i]))
                System.out.println(String.format("%s present in the trie", toFind[i]));
            else
                System.out.println(String.format("%s not present in the trie", toFind[i]));
        }
    }
}

