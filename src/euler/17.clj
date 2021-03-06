;; If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

;; If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

;; NOTE: Do not count spaces or hyphens. For example, 342 (three
;; hundred and forty-two) contains 23 letters and 115 (one hundred and
;; fifteen) contains 20 letters. The use of "and" when writing out
;; numbers is in compliance with British usage.

(def digits
     [""
      "one"
      "two"
      "three"
      "four"
      "five"
      "six"
      "seven"
      "eight"
      "nine"])

(def teens
     ["ten"
      "eleven"
      "twelve"
      "thirteen"
      "fourteen"
      "fifteen"
      "sixteen"
      "seventeen"
      "eighteen"
      "nineteen"])

(def tens
     [""
      ""
      "twenty"
      "thirty"
      "forty"
      "fifty"
      "sixty"
      "seventy"
      "eighty"
      "ninety"])

(defn two-digit
  [n]
  (let [n-str (str n)]
    (if (< n 20)
      (teens (Integer/parseInt (str (last n-str))))
      (str (tens (Integer/parseInt (str (first n-str))))
           (digits (Integer/parseInt (str (last n-str))))))))

(defn three-digit
  [n]
  (let [n-str (str n)
        hundreds (digits (Integer/parseInt (str (first n-str))))
        tens (Integer/parseInt (apply str (rest n-str)))]
    (if (zero? tens)
      (str hundreds "hundred")
      (str hundreds
           "hundred"
           "and"
           (if (< tens 10)
             (digits tens)
             (two-digit tens))))))

(defn number-as-string
  [n]
  (cond
   (< n 10) (digits n)
   (< n 100) (two-digit n)
   (< n 1000) (three-digit n)
   (= 1000) "onethousand"))


(three-digit 101)

;; (reduce +
;;         (map count
;;              (map number-as-string (range 1 1001))))

;; (apply println (interpose "\n" (map number-as-string (range 1 1001))))
