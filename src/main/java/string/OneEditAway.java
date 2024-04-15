package string;

/**
 * 一個編輯距離
 * 可以對字串執行的編輯有三種: 插入一個字元、刪除一個字元，或替換一個字元。
 * 假設有兩個字串，請寫一個函式檢查它們是否為1個(或0個)編輯距離
 */
public class OneEditAway {

    /**
     * 先透過檢查字串長度切割問題，再針對特定操作進行檢查
     * @param firstString
     * @param secondString
     * @return
     */
    public boolean isOneEditAway(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            return false;
        }

        if (firstString.length() == secondString.length()) {
            return oneEditReplace(firstString, secondString);
        } else if (firstString.length() == secondString.length() + 1) {
            return oneEditInsert(firstString, secondString);
        } else if (firstString.length() == secondString.length() - 1) {
            return oneEditInsert(secondString, firstString); // 沒必要寫 oneEditDelete，把 s1、s2 交換一下就好
        }

        return false;
    }

    private boolean oneEditReplace(String firstString, String secondString) {
        boolean foundDifference = false;
        for (int i = 0; i < firstString.length(); i++) {
            if (firstString.charAt(i) != secondString.charAt(i)) {
                if (foundDifference) {
                    return false;
                } else {
                    foundDifference = true;
                }
            }
        }
        return true;
    }

    private boolean oneEditInsert(String firstString, String secondString) {
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < firstString.length() && secondIndex < secondString.length()) {
            if (firstString.charAt(firstIndex) != secondString.charAt(secondIndex)) {
                if (firstIndex != secondIndex) {
                    return false;
                }
            } else {
                secondIndex++;
            }
            firstIndex++;
        }

        return true;
    }
}
