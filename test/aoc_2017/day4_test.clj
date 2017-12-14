(ns aoc-2017.day4-test
  (:require [aoc-2017.day4 :as sut]
            [clojure.test :refer [deftest is testing]]))

(deftest day4
  (testing "part 1"
    (is (sut/valid? identity "aa bb cc dd ee"))
    (is (not (sut/valid? identity "aa bb cc dd aa")))
    (is (sut/valid? identity "aa bb cc dd aaa"))
    (is (= 451 (count (sut/all-valid identity "input.txt")))))
  (testing "part 2"
    (is (sut/valid? sort "abcde fghij"))
    (is (not (sut/valid? sort "abcde xyz ecdab")))
    (is (sut/valid? sort "a ab abc abd abf abj"))
    (is (sut/valid? sort "iiii oiii ooii oooi oooo"))
    (is (not (sut/valid? sort "oiii ioii iioi iiio")))
    (is (= 223 (count (sut/all-valid sort "input.txt"))))))
