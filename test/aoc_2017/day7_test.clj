(ns aoc-2017.day7-test
  (:require [aoc-2017.day7 :refer [read-input into-graph bottom add-line-to-graph all-into-graph parse]]
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

(def s1-graph
  {:nodes #{{:name "gyxo", :weight 61}
            {:name "ugml", :weight 68}
            {:name "padx", :weight 45}
            {:name "ktlj", :weight 57}
            {:name "pbga", :weight 66}
            {:name "fwft", :weight 72}
            {:name "havc", :weight 66}
            {:name "xhth", :weight 57}
            {:name "ebii", :weight 61}
            {:name "qoyq", :weight 66}
            {:name "tknk", :weight 41}
            {:name "jptl", :weight 61}
            {:name "cntj", :weight 57}},
   :edges
   {"ugml" #{"gyxo" "ebii" "jptl"}
    "fwft" #{"cntj" "xhth" "ktlj"}
    "padx" #{"pbga" "havc" "qoyq"}
    "tknk" #{"ugml" "fwft" "padx"}}})

(deftest day7
  (testing "part 1"
    (is (= {:nodes #{{:name "a" :weight 10}} :edges {"a" #{"b" "c"}}}
           (add-line-to-graph {:nodes #{} :edges {}} {:name "a" :weight 10 :parents ["b" "c"]})))
    (is (= s1-graph (all-into-graph sample1)))
    (is (= "tknk" (bottom (all-into-graph sample1))))
    (is (= "eqgvf" (bottom (all-into-graph  (read-input "input.txt"))))))
  (testing "part 2"

    ))
