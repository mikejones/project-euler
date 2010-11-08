;; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

;; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?


(defn divisible-by
  [n]
  (every? #(zero? (mod n %))
          [2 3 5 7 11 13 17 19]))

(loop [n 21]
  (if (divisible-by n)
    (println n)
    (recur (inc n))))
