;; Using names.txt (right click and 'Save Link/Target As...'), a 46K
;; text file containing over five-thousand first names, begin by
;; sorting it into alphabetical order. Then working out the
;; alphabetical value for each name, multiply this value by its
;; alphabetical position in the list to obtain a name score.

;; For example, when the list is sorted into alphabetical order,
;; COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name
;; in the list. So, COLIN would obtain a score of 938 × 53 =49714.

;; What is the total of all the name scores in the file?

(def file-path
     "/Users/michaeljones/Workspace/clojure/euler/src/euler/names.txt")

(def names
     (slurp (.getCanonicalFile (clojure.java.io/file file-path))))

(def letters
     (reduce (fn [acc i]
               (assoc acc
                 (-> i char str)
                 (inc (count acc))))
             {}
             (range  65 91)))

(defn alphabetical-value
  [name]
  (reduce +
          (map #(letters (str %))
               name)))

(reduce + (map-indexed (fn [index name]
                (* (inc index)
                   (alphabetical-value name)))
              (sort (map #(clojure.string/replace % "\"" "")
                         (clojure.string/split names #",")))))

