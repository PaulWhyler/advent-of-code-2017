(ns aoc-2017.day2
  (:require [clojure.string :as str]))

(def input "resources/day2/input.txt")

(defn diff [coll]
  (->> coll
       (map #(Integer/parseInt %))
       (#(- (apply max %) (apply min %)))))

(defn checksum [s]
  (->> s
       (#(str/split % #"\n"))
       (map #(str/split % #"\s+"))
       (map diff)
       (reduce + 0)))
