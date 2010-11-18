;; Let d(n) be defined as the sum of proper divisors of n (numbers
;; less than n which divide evenly inton).

;; If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable
;; pair and each of a and b are called amicable numbers.


;; For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20,
;; 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of
;; 284 are 1, 2, 4, 71 and 142; so d(284)= 220.


;; Evaluate the sum of all the amicable numbers under 10000.


(defn proper-divisors
  [n]
  (let [max (Math/ceil (Math/sqrt n))]
    (reduce (fn [acc i]
              (if ( zero? (mod n i))
                (into acc [i (/ n i)])
                acc))
            [1]
            (range 2 max))))

(defn amicable?
  [n]
  (let [sum (reduce + (proper-divisors n))]
    (cond
     (= n sum) false
     (= n (reduce + (proper-divisors sum))) true
     :else false)))

(reduce +
        (filter amicable?
                (range 2 10001))) 
