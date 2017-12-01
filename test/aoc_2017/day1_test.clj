(ns aoc-2017.day1-test
  (:require [aoc-2017.day1 :as sut]
            [clojure.test :refer [deftest is testing]]))

(deftest day1
  (testing "part 1"
    (is (= 1089 (->> sut/input slurp sut/sum))))
  (testing "part 2"
    (is (= 6 (->> "1212\n" sut/part2-sum)))
    (is (= 0 (->> "1221\n" sut/part2-sum)))
    (is (= 4 (->> "123425\n" sut/part2-sum)))
    (is (= 12 (->> "123123\n" sut/part2-sum)))
    (is (= 4 (->> "12131415\n" sut/part2-sum)))
    (is (= 1156 (->> sut/input slurp sut/part2-sum)))))
