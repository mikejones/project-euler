;; How many routes are there through a 20×20 grid?

(defn factoral
  [n]
  (reduce *  (range 1
                    (+ n 1))))

(/ (factoral 40) (* (factoral 20) (factoral 20)))
