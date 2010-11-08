;; A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

;; Find the largest palindrome made from the product of two 3-digit
;; numbers.

(defn palindrome?
  [n]
  (let [n (.toString n)]
    (= n (apply str
                (reverse n)))))

(println (apply max
          (loop [x 999 y 999 palindromes []]
            (cond
             (= 0 x) palindromes 
             (= 0 y) (recur (dec x) 999 palindromes)
             (palindrome? (* x y)) (recur (dec x) 999 (cons (* x y)
                                                            palindromes))
             :else (recur x (dec y) palindromes)))))


