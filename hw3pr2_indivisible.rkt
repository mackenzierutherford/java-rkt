#lang racket
(require rackunit)
(provide indivisible)

;;indivisible
;;inputs: an element e and a list L
;;outputs: a list with the numbers indivisible by element e
;; using higher-order functions 
(define (indivisible e L)
  (filter (lambda (x) (not (= 0 (modulo x e)))) L))
  
  
; provided tests
(check-equal? (indivisible 3 '( 2 3 4 5 6 7 8 9 10 ))
                             '(2 4 5 7 8 10))
; student tests
(check-equal? (indivisible 1 '(1 2 3 4 5 6 7))
              '())
(check-equal? (indivisible 2 '(2 4 6 8))
              '())
              
