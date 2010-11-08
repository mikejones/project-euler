;The prime factors of 13195 are 5, 7, 13 and 29.

;What is the largest prime factor of the number 600851475143 ?

(defn primes-up-to [x]
  (loop [r (range 2 x)
         primes []]
    (if (empty? r)
      primes
      (let [p (first r)]
        (recur (filter #(not (= 0 (mod % p))) (rest r))
               (conj primes p))))))

(defn prime-factors [x]
  (loop [primes (primes-up-to x)
         hightest-factor 0]
    (if (empty? primes)
      hightest-factor
      (recur (rest primes)
             (let [p (first primes)]
               (if (= 0 (mod x p))
                 p
                 hightest-factor))))))

;(println (apply max (prime-factors 600851475143)))

(defn prime? [x] 
  (let [n (Math/ceil (Math/sqrt x))]
    n))

(defn highest-factor [x]
  (loop [i 2]
    (if (zero? (mod x i))
      (/ x i)
      (recur (inc i)))))


(defn highest-prime-factor [x]
  (let [highest-factor (highest-factor x)
        primes         (primes-up-to highest-factor)]
    highest-factor))

(println (prime? (highest-factor 600851475143)))

;(println (primes-up-to 30993))

