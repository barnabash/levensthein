(ns levensthein.core-test
  (:require [clojure.test :refer :all]
            [levensthein.core :refer :all]))

(deftest levensthein-distance
  (testing "levensthein"
    (is (= (levensthein "" "") 0))
    (is (= (levensthein "a" "") 1))
    (is (= (levensthein "" "a") 1))
    (is (= (levensthein "abc" "") 3))
    (is (= (levensthein "" "abc") 3))
    (is (= (levensthein "a" "ab") 1))
    (is (= (levensthein "ab" "a") 1))
    (is (= (levensthein "abc" "acc") 1))
    (is (= (levensthein "abcd" "xycd") 2))
    (is (= (levensthein "abcd" "abcd") 0))
    (is (= (levensthein "abc" "xyz") 3))))
