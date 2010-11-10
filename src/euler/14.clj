;; The following iterative sequence is defined for the set of positive integers:

;; n → n/2 (n is even)
;; n → 3n + 1 (n is odd)

;; Using the rule above and starting with 13, we generate the following sequence:
;; 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

;; It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

;; Which starting number, under one million, produces the longest
;; chain?

(defn sequence-length
  [start]
  (loop [n start
         length 1]
    (cond
     (= 1 n) length
     :else (if (odd? n)
             (recur (+ (* 3 n)
                       1)
                    (inc length))
             (recur (/ n 2)
                    (inc length))))))

(loop [r (range 1 1000000)
       max [0 0]]
  (if (empty? r)
    (first max)
    (let [n (first r)
          l (sequence-length n)]
      (recur (rest r)
             (if (> (last max) l)
               max
               [n l])))))

