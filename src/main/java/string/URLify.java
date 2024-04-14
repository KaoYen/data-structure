package string;

/**
 * 寫一個方法用'%20'來替換字串中所有空格，您可以假設字串的尾端有足夠的空間來容納額外的字元，並且您擁有字串的「真實」長度的資訊。
 */
public class URLify {

    /**
     * 在字串操作問題中，一種常見的方法是從尾巴開始一路向開頭編輯字串。 這很有用，因為我們在尾端有一個額外的緩衝區，它讓我們能修改字元，不必擔心覆蓋的內容。
     * 我們使用了字元陣列實作這個解答，因為 Java 字串是不可變的。 如果直接使用字串，函式將不得不回傳一個新的字串副本。 字元陣列讓我們用一次掃描就能做完。
     * @param strArray
     * @param trueLength
     * @return
     */
    public char[] replaceSpace(char[] strArray, int trueLength) {
        if (trueLength == 0) {
            return strArray;
        }

        int spaceCnt = 0;

        for (char c : strArray) {
            if (c == ' ') {
                spaceCnt++;
            }
        }

        int index = trueLength + 2 * spaceCnt;
        if (strArray.length > trueLength) {
            strArray[index] = '\0'; // 標記字串結尾
        }

        for (int i = trueLength - 1; i >= 0; i--) {
            if (strArray[i] == ' ') {
                strArray[index - 1] = '0';
                strArray[index - 2] = '2';
                strArray[index - 3] = '%';
                index = index - 3;
            } else {
                strArray[index - 1] = strArray[i];
                index--;
            }
        }

        return strArray;
    }

}
