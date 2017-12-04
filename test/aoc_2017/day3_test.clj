(ns aoc-2017.day3-test
  (:require [aoc-2017.day3 :as sut]
            [clojure.test :refer [deftest is testing]]))

(deftest day3
  (testing "helpers"
    (is (= 33 (sut/find-last-in-circle 1024)))
    (is (= 7 (sut/find-last-in-circle 45))))
  (testing "part 1"
    (is (= 0 (sut/distance 1)))
    (is (= 3 (sut/distance 12)))
    (is (= 2 (sut/distance 23)))
    (is (= 31 (sut/distance 1024)))
    (is (= 4 (sut/distance 25)))
    (is (= 4 (sut/distance 21)))
    (is (= 4 (sut/distance 17)))
    (is (= 4 (sut/distance 13)))
    (is (= 2 (sut/distance 9)))
    (is (= 6 (sut/distance 31)))
    (is (= 4 (sut/distance 53)))
    (is (= 5 (sut/distance 52)))
    (is (= 6 (sut/distance 51)))
    (is (= 430 (sut/distance 312051))))
  #_(testing "part 2"
    (is (= true false))))
