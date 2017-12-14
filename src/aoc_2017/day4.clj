(ns aoc-2017.day4
  (:require [clojure.string :as str]
            [clojure.pprint :refer [pprint]]
            [clojure.java.io :as io]))


(defn valid? [f s]
  (-> s
      (str/split #"\s+")
      (#(map f %))
      (#(vector (count %) (into #{} %)))
      (#(= (first %) (count (second %))))))

(defn all-valid [f s]
  (with-open [reader (io/reader "resources/day4/input.txt")]
    (into [] (->> reader
                  line-seq
                  (map (partial valid? f))
                  (filter true?)))))
