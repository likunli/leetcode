class Solution {

    /**
     * @param String $s
     * @return Boolean
     */
    function isValid($s) {
        
        $stack = [];
        foreach (str_split($s) as $char) {
            if ($char == '[' || $char == '{' || $char == '(') {
                array_push($stack, $char);
            } elseif ($char == ']') {
                if (!count($stack) || array_pop($stack) != '[') {
                    return false;
                }
            } elseif ($char == ')') {
                if (!count($stack) || array_pop($stack) != '(') {
                    return false;
                }
            } elseif ($char == '}') {
                if (!count($stack) || array_pop($stack) != '{') {
                    return false;
                }
            }
        }
        return count($stack) == 0;
    }
}
