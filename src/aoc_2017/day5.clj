(ns aoc-2017.day5
  (:require [clojure.string :as str]
            [clojure.pprint :refer [pprint]]
            [clojure.java.io :as io]))


(defn read-input [filename]
  (with-open [reader (io/reader (str "resources/day5/" filename))]
    (into [] (->> reader
                 line-seq
                 (map #(Integer/parseInt %))))))

(defn update-instructions [offsets offset f]
  (let [a (get offsets offset)]
    (vector (update offsets offset f) (+ a offset))))

(defn steps* [v part]
  (let [c (count v)]
    (loop [[offsets offset] [v 0]
           taken 0]
      (if (and (>= offset 0) (< offset c))
        (recur (update-instructions offsets offset part) (inc taken))
        taken))))

(defn steps [v]
  (steps* v inc))

(defn steps2 [v]
  (steps* v #(if (>= % 3) (dec %) (inc %))))
