class Solution {

    /**
     * @param String[] $s
     * @return NULL
     */
    function reverseString(&$s) {
        for ($i = 0; $i < count($s) / 2; $i++) {
            $this->swap($s, $i, count($s) - $i - 1);
        }
    }
    
    function swap(&$s, $left, $right) {
        $tmp = $s[$left];
        $s[$left] = $s[$right];
        $s[$right] = $tmp;
    }
}
