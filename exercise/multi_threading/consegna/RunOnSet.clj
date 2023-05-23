(def data #{3 13 88 97 234 245634 2342 2346 9809 3024 392})

(defn run-with-args [i]
  (println (quot i 2)))

(pmap run-with-args data)
