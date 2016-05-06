(ns levensthein.core)

(defn- next-val
  [ch1 prev-row row [pos ch2]]
  (let [diagonal (nth prev-row (dec pos))]
    (if (= ch1 ch2)
      (conj row diagonal)
      (conj row (inc
                  (min
                    diagonal
                    (nth prev-row pos)
                    (last row)))))))

(defn levensthein
  "Returns levensthein distance between two strigns"
  [s1 s2]
  (cond
    (empty? s1) (count s2)
    (empty? s2) (count s1)
    :else
    (loop [prev-row (take (inc (count s2)) (iterate inc 0))
           row-number 1]
          (if (> row-number (count s1))
            (last prev-row)
            (let [row (map vector (iterate inc 1) s2)
                  ch1 (nth s1 (dec row-number))]
              (recur (reduce #(next-val ch1 prev-row %1 %2) [row-number] row) (inc row-number)))))))

(defn similarity
  "Returns similarity between two strings"
  [s1 s2]
  (let [total (max (count s1) (count s2))]
    (- 1 (/ (levensthein s1 s2) total))))
