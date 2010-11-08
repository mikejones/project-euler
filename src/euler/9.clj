;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;; a^(2) + b^(2) = c^(2)

;; For example, 3^(2) + 4^(2) = 9 + 16 = 25 = 5^(2).

;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc.

;; a + b + c = 1000
;; a + b = 1000 - c
;; 1000 - (a + b) = c

(defn square
  [n]
  (* n n))

(defn pythagorean-triplet?
  [[a b c]]
  (= (+ (square a)
        (square b))
     (square c)))

(reduce *
        (first (filter pythagorean-triplet?
                       (for [a (range 1000)
                             b (range 1000)
                             :when (and (> 1000 (+ a b))
                                        (< a
                                           b
                                           (- 1000 (+ a b))))]
                         [a b (- 1000 (+ a b))]))))



