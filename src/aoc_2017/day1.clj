(ns aoc-2017.day1)

(def input "resources/day1/input.txt")

(defn sum [s]
  (->> s
       seq
       butlast
       (partition 2 1)
       (#(conj % (list (ffirst %) (last (last %)))))
       (filter #(= (first %) (second %)))
       (reduce (fn [sum [i _]]
                 (+ sum (- (int i) 48)))
               0)))
(->> input
     slurp
     sum)

(->> "1122\n" sum)
(->> "1111\n" sum)

(defn part2-sum [s]
  (->> s
       seq
       butlast
       (repeat 2)
       flatten
       (#(take (* (/ (count %) 4) 3) %))
       (#(map (fn [a b] (list a b)) % (drop (/ (count %) 3) %)))
       (filter #(= (first %) (second %)))
       (reduce (fn [sum [i _]]
                 (+ sum (- (int i) 48)))
               0)))
