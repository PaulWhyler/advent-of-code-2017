(ns aoc-2017.day3
  (:require [clojure.string :as str]
            [clojure.pprint :refer [pprint]]))

(def next-dir {:U :L :L :D :D :R :R :U})

(defn moves
  ([]
   (moves :R 0 0))
  ([dir cur nex]
   (lazy-seq
    (let [change-dir (zero? cur)
          next-dir (if change-dir (next-dir dir) dir)
          next-cur (if change-dir nex (dec cur))
          next-nex (if (and change-dir (#{:L :R} dir)) (inc nex) nex)]
      (cons dir
            (moves next-dir next-cur next-nex))))))

(def move {:U [0 -1] :L [-1 0] :D [0 1] :R [1 0]})

(defn add [[x y] [a b]]
  [(+ x a) (+ y b)])

(defn solve
  [n init f finish]
  (let [[x y]
        (reduce f
                init
                (take (dec n) (moves)))]
    [(+ (Math/abs x) (Math/abs y)) [x y]]))


(def distance (let [[dist final-pos] (solve 312051 [0 0] (fn [pos m] (add pos (move m))) :a)]
                dist))

(def adjacents [[-1 -1] [0 -1] [1 -1] [1 0] [1 1] [0 1] [-1 1] [-1 0]])

(reduce (fn [[acc pos] m]
          (let [next-pos (add pos (move m))
                v (reduce +
                        0
                        (->> adjacents
                             (map #(add pos %))
                             (map #(get acc % 0))))]
            [(assoc acc next-pos v) next-pos]))
        [{[0 0] 1} [0 0]]
        (take 10 (moves)))
