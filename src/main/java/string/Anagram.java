package string;

import java.util.Arrays;

/**
 * 給定兩個字串，寫一個方法來判斷一個是否是另一個的變位字
 * 注意: 應該先確認是否區分大小寫? 空白是否造成影響? 如: "dog" 與 "dog "是一樣的嗎?
 */
public class Anagram {

    /**
     * 先建立一個運作起來有點像雜湊表的陣列(letters)，將每個字元映射到期頻率。
     * 在處理第一個字串時做遞增，然後在處理第二個字串時做遞減。
     * 如果字串互相為對方的變位字，那麼陣列最後都會歸0。
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isAnagramUseArray(String s1, String s2) {
        int s1Length = s1 == null ? 0 : s1.length();
        int s2Length = s2 == null ? 0 : s2.length();
        if (s1Length != s2Length) {
            return false;
        }
        if (s1Length == 0) {
            return true;
        }

        int[] letters = new int[128]; //假設ASCII
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            letters[s2.charAt(i)]--;
            if (letters[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 邏輯同上，改用 int 減少空間複雜度，但每次都必須迭代完整的 s1 與 s2
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isAnagramUseInteger(String s1, String s2) {
        int s1Length = s1 == null ? 0 : s1.length();
        int s2Length = s2 == null ? 0 : s2.length();
        if (s1Length != s2Length) {
            return false;
        }
        if (s1Length == 0) {
            return true;
        }

        int checker = 0;
        for (int i = 0; i < s1.length(); i++) {
            checker += s1.charAt(i);
            checker -= s2.charAt(i);
        }

        return checker == 0;
    }

    /**
     * 排序後進行比較
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isAnagramUseSort(String s1, String s2) {
        int s1Length = s1 == null ? 0 : s1.length();
        int s2Length = s2 == null ? 0 : s2.length();
        if (s1Length != s2Length) {
            return false;
        }
        if (s1Length == 0) {
            return true;
        }

        return sort(s1).equals(sort(s2));
    }

    private String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

}
