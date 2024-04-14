package string;

/**
 * 實作一個演算法來判斷一個字串中的字元是否不重複
 * 注意: 最好先確認字串是ASCII字串還是Unicode字串 -> ASCII:128、EASCII:256、Unicode: 65536
 */
public class UniqueCharacters {

    /**
     * 使用字元集
     * 時間複雜度: O(n)、空間複雜度O(1)
     * 如果不想假設字元集是固定的，可以將空間複雜度表示為O(c)，時間複雜度為O(min(c, n))或O(c)，其中c是字元集的大小
     *
     * @param str
     * @return
     */
    public static boolean hasUniqueCharacters(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            if (charSet[str.charAt(i)]) {
                return false;
            }
            charSet[str.charAt(i)] = true;
        }
        return true;
    }

    /**
     * 利用位元向量將空間使用減少到 1/8
     * 下面程式碼中，將假設字串只能使用小寫字母a-z，這將只需要使用一個int
     * 1<<a: 1 、1<<b: 10、1<<c:100，將a-z用2進位轉換到int位數上，與0做&運算，若不重複checker必定為0
     *
     * @param str
     * @return
     */
    public static boolean hasUniqueCharactersUseBitwiseOperation(String str) {
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }

            checker |= (1 << val);
        }
        return true;
    }
}
