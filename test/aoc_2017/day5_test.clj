(ns aoc-2017.day5-test
  (:require [aoc-2017.day5 :as sut]
            [clojure.test :refer [deftest is testing]]))

(deftest day5
  (testing "part 1"
    (is (= 5 (sut/steps [0 3 0 1 -3])))
    (is (= 359348 (sut/steps (sut/read-input "input.txt")))))
  (testing "part 2"
    (is (= 10 (sut/steps2 [0 3 0 1 -3])))
    (is (= 27688760 (sut/steps2 (sut/read-input "input.txt"))))))
