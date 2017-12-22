(ns aoc-2017.day7-test
  (:require [aoc-2017.day7 :refer [read-input into-graph bottom]]
            [clojure.test :refer [deftest is testing]]))

(def sample1
"pbga (66)
xhth (57)
ebii (61)
havc (66)
ktlj (57)
fwft (72) -> ktlj, cntj, xhth
qoyq (66)
padx (45) -> pbga, havc, qoyq
tknk (41) -> ugml, padx, fwft
jptl (61)
ugml (68) -> gyxo, ebii, jptl
gyxo (61)
cntj (57)")

(deftest day7
  (testing "part 1"
    (is (= "tknk" (bottom sample1)))
    (is (= "?" (bottom (read-input "input.txt")))))
  (testing "part 2"

    ))
