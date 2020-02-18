class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $map = [];
        for ($i = 0; $i < count($nums); $i++) {
            $diff = $target - $nums[$i];
            if ($map[$diff] !== null) {
                return [$map[$diff], $i];
            }
            $map[$nums[$i]] = $i;
        }
        return [0, 0];
    }
}
