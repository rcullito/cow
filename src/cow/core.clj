(ns cow.core
  (:require [clojure.core.logic :refer :all]
            [clojure.core.logic.fd :as fd]))


;; todo integers that sum to 10
(run* [q]
  (fd/in q (fd/interval 1 5)))

(run* [q]
  (fresh [x y]
    (fd/in x y (fd/interval 1 10))
    (fd/+ x y 10)
    (fd/>= x y) ;; rc addition
    (== q [x y])))


 (run* [q]
   (membero q [1 2 3])
   (membero q [2 3 4]))

;; build up a basket where the money left over is less than the cheapest stock
(def budget 100)
(def price-weights '([12 .50] [4 .25] [3 .25]))

price-weights

;; goals
;;1. don't exceed budget

;; so each upper bound would be assuming we only got that asset on this run
;; really it's not the sum of x y and z but the sum of

(def ideal-shares-x (* 100 0.50))


12 * x must be in this interval 
(fd/interval (- ideal-shares-x 5) (+ ideal-shares-x 5))


what we are curious about is x * 12 being in that interval, then what is x
mplus

(run* [q]
  (fresh [x y]
    ;; initial goals
    ;; the max for the number of shares would be the value
    (membero x (range 0 (/ budget 12)))
    (membero y (range 0 (/ budget 4)))
    ;; goal 1 the sum of the number of shares times their price
    ;; cannot exceed the budget
    (fd/eq
     (<= (+ (* 12 x) (* 4 y)) budget))
    ;; nice! we probably need one more clause to achieve the max behavior
    ;; the difference between the budget and the basket cannot be greater than the cheapest asset
    (fd/eq
     (> 4 (- budget (+ (* 12 x) (* 4 y)))))
    ;; that is good for today 12/3 :)
    (== q [x y])))

(> 4 6)
(* 7 12)

(+ 48 21)

#_(run* [q]
  (fresh [x y z]
    (fd/in x (fd/interval 0 35))
    (fd/in y (fd/interval 0 30))
    (fd/in z (fd/interval 0 40))
    (fd/eq
     (> 
      100
      (+ x y z)))
    (== q [x y z])))
