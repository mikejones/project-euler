;The prime factors of 13195 are 5, 7, 13 and 29.

;What is the largest prime factor of the number 600851475143 ?

(ns euler.3
  (:require [clojure.contrib.lazy-seqs :as lazy]))

(def max-prime (Math/ceil (Math/sqrt 600851475143)))

(loop [primes lazy/primes max-factor 0]
  (let [p (first primes)]
    (cond
     (> p max-prime) max-factor
     :else (if (zero? (mod 600851475143 p))
             (recur (rest primes) p)
             (recur (rest primes) max-factor)))))


