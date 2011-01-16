;; You are given the following information, but you may prefer to do
;; some research for yourself.

;;     * 1 Jan 1900 was a Monday.
;;     * Thirty days has September,
;;       April, June and November.
;;       All the rest have thirty-one,
;;       Saving February alone,
;;       Which has twenty-eight, rain or shine.
;;       And on leap years, twenty-nine.
;;     * A leap year occurs on any year evenly divisible by 4, but not
;;     * on a century unless it is divisible by 400.

;; How many Sundays fell on the first of the month during the
;; twentieth century (1 Jan 1901 to 31 Dec 2000)?

(defn leap-year
  [year]
  (cond
   (zero? (mod year 400)) true
   (zero? (mod year 100)) false
   (zero? (mod year 4)) true
   :else false))

(defn days-in-months
  [year]
  [[:january 31]
   [:february (if (leap-year year) 29 28)]
   [:march 31]
   [:april 30]
   [:may 31]
   [:june 30]
   [:july 31]
   [:august 31]
   [:september 30]
   [:october 31]
   [:november 30]
   [:december 31]])

(def days-of-week
     (cycle [:mon :tue :wed :thur :fri :sat :sun]))

(defn first-days-of-months
  [year dow-wheel]
  (loop [dim (days-in-months year) dow dow-wheel res []]
    (let [f (first dim)]
      (if (empty? f)
        res
        (let [[m d] f]
          (recur (rest dim)
                 (drop d dow)
                 (conj res (first dow))))))))

(count (filter #(= :sun %)
               (flatten (loop [dow days-of-week year 1901 result []]
                          (if (= 2001 year)
                            result
                            (let [total-days (reduce + (map second (days-in-months year)))
                                  fdom (first-days-of-months year dow)]
                              (recur (drop total-days dow)
                                     (inc year)
                                     (conj result fdom))))))))

