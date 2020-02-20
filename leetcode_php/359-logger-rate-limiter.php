class Logger {
    /**
     * Initialize your data structure here.
     */
    function __construct() {
        $this->container = [];
    }
  
    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
     * @param Integer $timestamp
     * @param String $message
     * @return Boolean
     */
    function shouldPrintMessage($timestamp, $message) {
        if (!isset($this->container[$message])) {
            $this->container[$message] = $timestamp;
            return true;
        } else {
            $last = $this->container[$message];
            if ($timestamp - $last >= 10) {
                $this->container[$message] = $timestamp;
                return true;
            } else {
                return false;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * $obj = Logger();
 * $ret_1 = $obj->shouldPrintMessage($timestamp, $message);
 */
