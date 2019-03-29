class Solution {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        
        int pre = A[0];
        boolean hasPeak = false;
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                pre = A[i];
                continue;
            }
            
            if(!hasPeak) {
                if (A[i] > pre) {
                    pre = A[i];
                } else {
                    if (i == 1) {
                        return false;
                    }
                    hasPeak = true;
                    i--;
                }
                continue;
            }
            
            if (hasPeak) {
                if (A[i] < pre) {
                    pre = A[i];
                } else {
                    return false;
                }
            }
            
        }
        return hasPeak;
    }
}
