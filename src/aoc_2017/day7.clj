(ns aoc-2017.day7
  (:require [clojure.string :as str]
            [clojure.pprint :refer [pprint]]
            [clojure.java.io :as io]
            [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gs]))

(s/def ::name (s/& string? #(> (count %) 0)))
(s/def ::weight integer?)
(s/def ::children (s/+ ::name))
(s/def ::node (s/cat :name ::name :weight ::weight :sep #{"->"} :children ::children))

(defn read-input [filename]
  (->> (str "resources/day7/" filename)
       slurp
       (#(str/split % #"\s+"))
       (into [])))


(def a (slurp "resources/day7/input.txt"))

(def b (str/split a #"\n"))

(def c (edn/read-string (str "[" (first b) "]")))

(s/conform ::node (apply conj  [] (str (first c)) (first (second c)) (map str (drop 2 c))))

(s/exercise ::node)
