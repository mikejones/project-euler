;; The series, 1^(1) + 2^(2) + 3^(3) + ... + 10^(10) = 10405071317.

;; Find the last ten digits of the series, 1^(1) + 2^(2) + 3^(3) +
;; ... + 1000^(1000).

(apply str (reverse (subvec (-> (reduce #(.add %1
                                               (.pow (BigInteger. (str %2)) %2))
                                        (BigInteger. "0")
                                        (range 1 1001))
                                str
                                reverse
                                vec)
                            0 10)))




