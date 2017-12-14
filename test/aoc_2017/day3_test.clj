(ns aoc-2017.day3-test
  (:require [aoc-2017.day3 :as sut]
            [clojure.test :refer [deftest is testing]]))

(deftest day3
  (testing "part 1"
    (is (= 0 (sut/distance 1)))
    (is (= 3 (sut/distance 12)))
    (is (= 2 (sut/distance 23)))
    (is (= 31 (sut/distance 1024)))
    (is (= 430 (sut/distance 312051))))
  (testing "part 2"
    (is (= 362 (sut/solve2 357)))
    (is (= 312453 (sut/solve2 312051)))))

(def array

  [[ new  cor  cen-   cor  cen-1    cor  last-cen last-cor  new   cen     cen    cor    cen+        cen   ]
   [0 1   2     3     4     5      6         7      8       9      10       11    12     13         14]
   [1 1   2     4     5    10     11        23      25     26      54       57    59     122        133 ]
   [0 1 [1 1][1 1 2][1 4][1 4 5] [1 10][1 1 10 11][1 1 23][1 25][1 25 26][1 2 54][2 57][2 4 57 59][2 4 5 122]]
   [  1 [0 1][0 1 2][0 3][0 3 4] [0 5]][0 1 5 6]  [0 1 7] [1 8] [1 8 9]  [1 2 10][2 11][2 3 11 12][2 3 4 13]])

(def array2
  [[ cen-1    cor    cen         cen          cen-1      cor     cen+1      cen              cen-1         cor       new ]
   [ 15       16      17          18          19          20      21          22             23             24       25  ]
   [142       147    304         330          351        362     747         806             880            931       957 ]
   [4 5 142][5 142][5 10 142 147][5 10 11 304][10 11 330][11 351][11 351 362][11 23 25 747][23 25 26 806][25 26 880][26 931]
   [3 4 14] [4 15] [4 5 15 16]   [4 5 6 17]   [5  6  18] [6  19] [6 19 20]   [6  7  8  21] [7  8  9  22] [8  9  23] [9  24]])

;0                  2
;0 1                3
;0                  4
;0 3                5
;0                  6
;0 1 5              7
;0 1                8
;1                  9
;1 8               10
;1 2               11
;2                 12
;2 3 11            13
;2 3 4             14
;3 4               15
;4                 16
;4 5 15            17
;4 5 6             18
;5 6               19
;6                 20
;6 19              21
;6 7 8             22
;7 8 9             23
;8 9               24
;9                 25

(def sizes-of-squares
  [1 8 16 24 32 40 48])

;; one after a corner always includes previous 2, plus (if big enough) (size/2 + 1) ?

(def g (go))

(defn f [v]
  (condp = v
    1 1
    2 1
    3 2
    4 4
    5 5
    6 10
    7 11
    8 23
    9 25
    (+ (nth g (dec v))(nth g (- v 9)))))

(defn go
  ([]
   (let [s (drop 1 (range))]
     (lazy-seq (cons (f (first s))
                     (go (rest s))))))
  ([s]
   (lazy-seq (cons (f (first s))
                   (go (rest s))))))

(deftest day3-part2
  (is (= 1 (last (go 1))))
  (is (= 1 (last (go 2)))))

(defn add-one [se]
  (lazy-seq (cons (inc (first se))
                  (add-one (rest se)))))

(deftest day3-part2
  (testing "corner?"
    (is (sut/corner? 2))
    (is (sut/corner? 3))
    (is (sut/corner? 10))
    (is (sut/corner? 2))
    (is (sut/corner? 26)))
  (testing "first-in-prior-circle"
    (is (= 10 (sut/first-in-prior-circle 29))))
  (testing "adjacent"
    (is (= #{1} (sut/adjacent 2)))
    (is (= #{1 2} (sut/adjacent 3)))
    (is (= #{1 5} (sut/adjacent 6)))
    (is (= #{1 6} (sut/adjacent 7)))
    (is (= #{1 2 6 7} (sut/adjacent 8)))
    (is (= #{1 2 8} (sut/adjacent 9)))
    (is (= #{49 26} (sut/adjacent 50)))
    (is (= #{17 36} (sut/adjacent 37)))
    (is (= #{21 42} (sut/adjacent 43)))
    (is (= #{26 27 49 50} (sut/adjacent 51)))
    (is (= #{50 51 81 82} (sut/adjacent 83)))
    (is (= #{2 3 9 10} (sut/adjacent 11)))

    (is (= #{26 27 28 51} (sut/adjacent 52)))
    (is (= #{29 39 31 54} (sut/adjacent 55)))))


(deftest day3-part1-again
  (is (= [:R :U :L :L :D :D :R :R :R :U :U :U :L :L :L :L :D :D :D :D] (take 20 (sut/moves)))))
