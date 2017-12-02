(ns aoc-2017.day2-test
  (:require [aoc-2017.day2 :as sut]
            [clojure.test :refer [deftest is testing]]))

(deftest day2
  (testing "part 1"
    (is (= 18 (sut/checksum "5 1 9 5\n7 5 3\n2 4 6 8")))
    (is (= 0 (sut/checksum (slurp sut/input)))))
  (testing "part 2"
    (is (= true false))))
