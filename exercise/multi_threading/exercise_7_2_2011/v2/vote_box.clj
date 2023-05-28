(defn votebox [n]
  "Create a new votebox that can be used by `n` threads."
  (atom {:votes 0 :current-voted #{} :total-voters n}))

(defn done? [v]
  "Predicate to check if the votation on `v` has ended."
  (= (count (:current-voted @v)) (:total-voters @v)))

(defn vote [v r]
  "Vote `r`, that can be true or false, on the votebox `v`."
  (cond (get (:current-voted @v) (Thread/currentThread)) (throw (RuntimeException. "This thread already voted"))
        (done? v) (throw (RuntimeException. "The votation has ended"))
        :else (swap! v (fn [m]
                         (-> m
                             (update :current-voted #(conj % (Thread/currentThread)))
                             (update :votes #(if r (inc %) (dec %))))))))

(defn wait-for-result [v]
  "Wait for the votation to end and retrieve the result")
;; How I can avoid active wait and thread sleep?
;; Maybe the atom is not the best for this use case
;; Try with agents
