(ns aoc-2017.day3
  (:require [clojure.string :as str]
            [clojure.pprint :refer [pprint]]))

(defn find-last-in-circle [n]
  (loop [r 3]
    (if (>= (* r r) n)
      r
      (recur (+ 2 r)))))

(defn find-corner [r n]
  (let [segment-size (/ (dec r) 2)
        last-corner (* (- r 2) (- r 2))]
    (loop [corner (* r r)]
      (if (= corner last-corner)
        :invalid
        (cond
          (= (- corner segment-size) n)
          segment-size
          (<= (- corner segment-size) n corner)
          (- (+ segment-size segment-size) (- corner n))
          (< (- corner segment-size segment-size) n (- corner segment-size))
          (- (* 2 segment-size) (- n (- corner segment-size segment-size)))
          :else
          (recur (- corner segment-size segment-size)))))))

(defn distance [start]
  (if (= 1 start)
    0
    (let [r (find-last-in-circle start)]
      (find-corner r start))))



#_(comment

  number in each circle
  1
  8 = 3 + 2 + 2 + 1
  16 = 5 + 4 + 4 + 3
  24 = 7 + 6 + 6 + 5
  32 = 9 + 8 + 8 + 7

65 64 63 62 61 60 59 58 57
66 37 36 35 34 33 32 31 56
67 38 17 16 15 14 13 30 55
68 39 18  5  4  3 12 29 54
69 40 19  6  1  2 11 28 53
70 41 20  7  8  9 10 27 52
71 42 21 22 23 24 25 26 51
72 43 44 45 46 47 48 49 50
73 74 75 76 77 78 79 80 81 82

last number in each circle
1 = 1 ** 2
9  = 3 ** 2
25 = 5 ** 2
49 = 7 ** 2
81 = 9 ** 2

e.g. 1024
From the last number of the circle that contains the target  1089 = 33 ** 2
Take 2 from the sqrt  31. + 1 and half  = 16
Find segment containing number
1089 - 16 = 1073  no
1073 - 16 = 1057  no
1057 - 16 = 1041  no
1041 - 16 = 1025  no
1025 - 16 = 1009  yes

difference between last number and target 1025 - 1024 = 1

Manhatten distance = 33 - 1 - that difference = 31.

So, find the right root, find the segment, add or subtract

first number on each circle
1
2
    10 = 8 + 2   = start loop 3
+16 26 = 3 * 8 + 2 = start loop 4
+24 50 = 6 * 8 + 2 = start loop 5
+32 82 = 10 * 8 + 2 = start loop 6
+40 122 = 15 * 8 + 2 = start loop 7
+48 170 = 21 * 8 + 2 = start loop 8
+56 226 = 28 * 8 + 2 = start loop 9

1024 = 128 * 8 or = 127 * 8 + 2 + 6
)
