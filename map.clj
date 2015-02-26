(defn map-without-tail-call-recursion ; this will blow up for non-trivial sized collections
  [f coll]
  (cons (f (first coll))
        (map-without-tail-call-recursion f (rest coll))))

(defn map
  [f coll]
  (letfn [map-internal ([f acc coll] ; we have to create an internal function that handles tail-call recursion
                         (if (seq coll)
                           (recur f (conj acc (f (first coll))) (rest coll))
                           acc))]
    (map-internal f [] coll))

(defn map-using-reduce ; by using reduce, we take advantage of an hof that already, but what happens with infinite lists?
  [f coll]
  (reduce (fn [acc item]
            (conj acc (f item)))
          []
          coll))
