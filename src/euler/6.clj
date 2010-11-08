;; The sum of the squares of the first ten natural numbers is,
;; 1^(2) + 2^(2) + ... + 10^(2) = 385

;; The square of the sum of the first ten natural numbers is,
;; (1 + 2 + ... + 10)^(2) = 55^(2) = 3025

(defn square
  [n]
  (* n n ))


(defn sum-of-squares
  [r]
  (reduce +
          (map square
               r)))

(defn square-of-sums
  [r]
     (square (reduce + r)))

(println (- (sum-of-squares (range 1 101))
            (square-of-sums (range 1 101))))

