(ns aoc-2017.day6
  (:require [clojure.string :as str]
            [clojure.pprint :refer [pprint]]
            [clojure.java.io :as io]))


(defn read-input [filename]
  (->> (str "resources/day6/" filename)
       slurp
       (#(str/split % #"\s+"))
       (map #(Integer/parseInt %))
       (into [])))

(defn redist [v]
  (let [m (apply max v)
        i (.indexOf v m)]
    (reduce (fn [acc n]
              (update acc n inc))
            (assoc v i 0)
            (->> v
                 count
                 range
                 repeat
                 flatten
                 (drop (inc i))
                 (take m)))))

(defn steps* [v part2?]
  (loop [v v
         so-far 0
         seen #{}
         first-seen nil
         first-seen-count 0]
    (if (seen v)
      (if part2?
        (if (= first-seen v)
          first-seen-count
          (recur (redist v) (inc so-far) (conj seen v) (if first-seen first-seen v) (inc first-seen-count)))
        so-far)
      (recur (redist v) (inc so-far) (conj seen v) first-seen 0))))

(defn steps [v] (steps* v nil))

(defn steps2 [v] (steps* v true))
