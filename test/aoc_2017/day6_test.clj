(ns aoc-2017.day6-test
  (:require [aoc-2017.day6 :as sut]
            [clojure.test :refer [deftest is testing]]))

(deftest day6
  (testing "part 1"
    (is (= 5 (sut/steps [0 2 7 0])))
    (is (= 6681 (sut/steps (sut/read-input "input.txt")))))
  (testing "part 2"
    (is (= 4 (sut/steps2 [0 2 7 0])))
    ))
