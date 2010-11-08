;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6^(th) prime is 13.

;; What is the 10001^(st) prime number?

(defn prime?
  [n primes]
  (not-any? #(zero? (mod % n))
            primes))

(loop [n 13 primes [2 3 5 7 11]]
  (cond (= 10001 (count primes)) (last primes)
        (prime? n primes) (recur (+ n 2) (conj primes n))
        :else (recur (+ n 2) primes)))
