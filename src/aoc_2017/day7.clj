(ns aoc-2017.day7
  (:require [clojure.string :as str]
            [clojure.edn :as edn]
            [clojure.pprint :refer [pprint]]
            [clojure.java.io :as io]
            [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gs]
            [clojure.test.check.generators :as gen]))

(declare into-graph bottom)

(s/def ::name (s/with-gen
                (s/conformer str #(> (count %) 0))
                gs/symbol))
(s/def ::weight (s/with-gen
                  (s/conformer first integer?)
                  #(gs/fmap list gen/nat)))
(s/def ::children (s/+ ::name))
(s/def ::node (s/cat :name ::name :weight ::weight :sep (s/? #{'->}) :children (s/? ::children)))

(defn parse [s]
  (->> s
       (.split #"\n")
       (map #(edn/read-string (str "[" % "]")))))

(defn read-input [filename]
  (->> (str "resources/day7/" filename)
       slurp))


(def a (slurp "resources/day7/input.txt"))

(def b (str/split a #"\n"))

(def c (edn/read-string (str "[" (first b) "]")))

(s/conform ::node c)

(take 2 (s/exercise ::node))

(defn add-line-to-graph [{:keys [nodes edges] :as graph} {:keys [name weight parents]}]
  (-> graph
      (update-in [:nodes] conj {:name name :weight weight})
      (update-in [:edges] #(if parents (assoc % name (set parents)) %)
                 #_#(apply conj % (map (fn [child] #{name child}) children)))))

(defn into-graph [lines]
  (reduce add-line-to-graph
          {:nodes #{} :edges {}}
          lines))

(defn all-into-graph [s]
  (->> s
       parse
       (map (partial s/conform ::node))
       into-graph))

(defn bottom [graph]
  (loop [node (:name (first (:nodes graph)))
         edges (rest (:edges graph))
         edge (first (:edges graph))]
   (if (not edge)
      node
      (if (contains? (second edge) node)
        (recur (first edge) (rest (:edges graph)) (first (:edges graph)))
        (recur node (rest edges) (first edges))))))
