;; n! means n × (n − 1) × ... × 3 × 2 × 1

;; Find the sum of the digits in the number 100!

(defn n!
  [n]
  (if (= 1 n)
    n
    (* n (n! (dec n)))))

(reduce + (map #(Integer/parseInt (.toString %))
               (.toString (n! 100))))
