(ns aoc-2017.day2-test
  (:require [aoc-2017.day2 :as sut]
            [clojure.test :refer [deftest is testing]]))

(deftest day2
  (testing "part 1"
    (is (= 18 (sut/checksum sut/diff "5 1 9 5\n7 5 3\n2 4 6 8")))
    (is (= 43074 (sut/checksum sut/diff (slurp sut/input)))))
  (testing "part 2"
    (is (= 9 (sut/checksum sut/divisible "5 9 2 8\n9 4 7 3\n3 8 6 5")))
    (is (= 280 (sut/checksum sut/divisible (slurp sut/input))))))
