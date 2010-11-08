;; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

;; Find the sum of all the primes below two million.



;; (defn prime?
;;   [n primes]
;;   (not-any? #(zero? (mod % n))
;;             primes))

;; (reduce +
;;           (loop [n 13 primes [2 3 5 7 11]]
;;             (cond (> n 2000000)  primes
;;                   (prime? n primes) (recur (+ n 2) (conj primes n))
;;                   :else (recur (+ n 2) primes))))

(require clojure.contrib.lazy-seqs)

(reduce +
        (take-while #(> 2000000 n) primes))



