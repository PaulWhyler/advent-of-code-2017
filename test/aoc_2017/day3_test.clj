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


(deftest day3-part1-again
  (is (= [:R :U :L :L :D :D :R :R :R :U :U :U :L :L :L :L :D :D :D :D] (take 20 (sut/moves)))))
