package string;

/**
 * 您得到一個字串，請寫一個函式來檢查它是否是一個回文變位字。
 * 回文的意思是單詞或短語無論向前或向後讀都是一樣的，ex. racecar、level。
 * 變位字就是字母的重新排列。
 * 回文不局限於字典單詞。
 */
public class PermutationOfPalindrome {

    /**
     * 我們使用一個雜湊表來計算每個字元出現的次數，然後迭代雜湊表，確保具有奇數計數的字元不超過一個
     * 這個演算法花費 O(N) 的時間，其中 N 是字串的長度
     *
     * @param phrase
     * @return
     */
    public boolean isPermutationOfPalindromeUseHashTable(String phrase) {
        if (phrase == null || phrase.length() == 0) {
            return false;
        }
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    /**
     * 檢查具有奇數計數的字元不超過一個
     *
     * @param table
     * @return
     */
    private boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /**
     * 將每個字元映射到一個數字。 a -> 0, b->1, c->2 ... 等等
     * 這是不區分大小寫的
     * 非字母字元映射到 -1
     *
     * @param c
     * @return
     */
    private int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }

        return -1;
    }

    private int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    /**
     * 如果更深入的思考這個問題，可能會注意到實際上不需要知道計數。 我們只需要知道計數是偶數還是奇數。
     * 想像一下，開/關一盞燈(剛開始是關的)，如果在結束時燈在關閉狀態，我們不需要知道中間開關多少次，因為這必定是偶數。
     *
     * 有了這個條件之後，我們可以使用一個整數(當成位元向量使用)。 當我們看到一個字母時，將它映射到 0 到 26 之間的整數(假設是字母)。
     * 然後在那個值的位置上切換位元值。 在迭代結束時，檢查整數中是不是最多只有一位元被設定為 1。
     *
     * 請想像有一個像 00010000 這樣的整數。 當然，我們可以多次位移整數來檢查是否只有一個 1。
     * 或者，如果把數字減去 1，就得到 00001111。 值得注意的是，這些數字之間不會交錯(一個反例是 00101000，當我們減去 1 時，會得到 00100111)。
     * 所以可以將它減去 1 然後再 AND 這個新數字來檢查一個數字是否恰好有一個 1，結果應該要得到 0。
     *
     * 這個解決方案的時間複雜度一樣是 O(N)。
     * @param phrase
     * @return
     */
    public boolean isPermutationOfPalindromeUseBitVector(String phrase) {
        if (phrase == null || phrase.length() == 0) {
            return false;
        }

        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    /**
     * 為字串建立一個位元向量
     * 為每個值為 i 的字母，切換第 i 位元的值
     * @param phrase
     * @return
     */
    private int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }

        return bitVector;
    }

    private int toggle(int bitVector, int index) {
        if (index < 0) {
            return bitVector;
        }

        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask; // 位元操作，通常用於清除掩碼(mask)對應位置上的位 > 在這個例子中，mask只會有一個位元為 1 ，用 XOR (^=) 也可以，上方的 & 判斷也可以移除
        }

        return bitVector;
    }

    private boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }
}
