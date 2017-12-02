(ns aoc-2017.day2
  (:require [clojure.string :as str]
            [clojure.pprint :refer [pprint]]))

(def input "resources/day2/input.txt")

(defn diff [coll]
  (->> coll
       (map #(Integer/parseInt %))
       (#(- (apply max %) (apply min %)))))

(defn divisible [coll]
  (let [coll (map #(Integer/parseInt %) coll)]
    (loop [num (first coll)
           numr (next coll)
           den (first coll)
           denr (next coll)]
      (if (and (not= num den) (zero? (mod num den)))
        (/ num den)
        (if denr
          (recur num numr (first denr) (next denr))
          (when numr (recur (first numr)(next numr) (first coll) (next coll))))))))

(defn checksum [f s]
  (->> s
       (#(str/split % #"\n"))
       (map #(str/split % #"\s+"))
       (map f)
       (reduce + 0)))
