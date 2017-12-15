(ns aoc-2017.day5-test
  (:require [aoc-2017.day5 :as sut]
            [clojure.test :refer [deftest is testing]]))


0
3
0
1
-3
Positive jumps ("forward") move downward; negative jumps move upward. For legibility in this example, these offset values will be written all on one line, with the current instruction marked in parentheses. The following steps would be taken before an exit is found:

(0) 3  0  1  -3  - before we have taken any steps.
(1) 3  0  1  -3  - jump with offset 0 (that is, don't jump at all). Fortunately, the instruction is then incremented to 1.
2 (3) 0  1  -3  - step forward because of the instruction we just modified. The first instruction is incremented again, now to 2.
2  4  0  1 (-3) - jump all the way to the end; leave a 4 behind.
2 (4) 0  1  -2  - go back to where we just were; increment -3 to -2.
2  5  0  1  -2  - jump 4 steps forward, escaping the maze.
In this example, the exit is reached in 5 steps.


(deftest day5
  (testing "part 1"
    (is (= 5 (sut/steps [0 3 0 1 -3])))
    (is (= 359348 (sut/steps (sut/read-input "input.txt")))))
  (testing "part 2"
    (is (= 10 (sut/steps2 [0 3 0 1 -3])))
    (is (= 27688760 (sut/steps2 (sut/read-input "input.txt"))))))
