(ns aoc-2017.day6-test
  (:require [aoc-2017.day6 :refer [read-input steps steps2]]
            [clojure.test :refer [deftest is testing]]))

(deftest day6
  (testing "part 1"
    (is (= 5 (steps [0 2 7 0])))
    (is (= 6681 (steps (read-input "input.txt")))))
  (testing "part 2"
    (is (= 4 (steps2 [0 2 7 0])))
    (is (= 2392 (steps2 (read-input "input.txt"))))
    ))
