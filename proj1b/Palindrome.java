public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        int size = word.length();
        Deque<Character> wordInDeque = new LinkedListDeque<>();//???
        for (int i=0; i<size;i++){
            wordInDeque.addLast(word.charAt(i));
        }
        return wordInDeque;
    }

    public boolean isPalindrome(String word){
        Deque d = wordToDeque(word);
        String reverse = "";
        for (int i = 0; i < word.length(); i++) {
            reverse += d.removeLast();
        }
//        return word.equals(reverse) ;
        return word.equals(reverse);
    }

    private boolean isPalindrome(Deque<Character> d, CharacterComparator cc){
//        Deque<Character> d = wordToDeque(word);
        while (d.size()>1){
            return cc.equalChars(d.removeFirst(),d.removeLast()) && isPalindrome(d,cc);
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        return isPalindrome(wordToDeque(word),cc);
    }


    }
