(defn naive-filter
  [p [h & r]]
  (if (p h)
    (cons h (naive-filter p r))
    (naive-filter p r)))
