(defn reduce
  ([f [h & r]] ; you don't have to specify the initial accumulator if you just want to use the first item in the list
   (recur f h r))
  ([f acc coll]
   (if (seq coll)
     (recur f ; recur is clojures mechanism for tail-call recursions
            (f acc (first coll))
            (rest coll))
     acc)))
