public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque dWord = new LinkedListDeque();
        for (int cnt = 0; cnt < word.length(); cnt += 1) {
            dWord.addLast(word.charAt(cnt));
        }
        return dWord;
    }

    public boolean isPalindrome(String word) {
        Deque dWord = this.wordToDeque(word);
        if (dWord.size() <= 1) {
            return true;
        } else {
            while (dWord.size() > 1) {
                if (dWord.removeFirst() != dWord.removeLast()) {
                    return false;
                }
            }
            return true;
        }
    }
}