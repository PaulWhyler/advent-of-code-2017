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
    (is (= true false))))
