(defn multiple-3-or-5? [x]
  (or
    (= 0 (mod x 3))
    (= 0 (mod x 5))))

(println (reduce + (filter multiple-3-or-5? (range 1 1000))))

