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

(def days-in-months
     [[:january 31]
      [:february 28]
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
  [dow-wheel]
  (loop [dim days-in-months dow dow-wheel res []]
    (let [f (first dim)]
      (if (empty? f)
        res
        (let [[m d] f]
          (recur (rest dim)
                 (drop d dow)
                 (conj res (first dow))))))))

(loop [dow days-of-week year 1901 result []]
  (if (= 2001 year)
    result
    (let [total-days (reduce + (map second days-in-months))
          first-days-of-month (first-days-of-month dow)]
      (recur (drop total-days dow)
             (inc year)
             (conj )))
    
    ))

(first days-in-months)

