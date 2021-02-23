(ns ser.ver
  (:require [ring.adapter.jetty :as j]))

(defn serve []
  (let [s (atom 0)]
    (j/run-jetty
     (fn [req]
       {:status 200
        :body (str (swap! s inc))})
     {:join? false
      :port 3000})))
(comment
  (def s (serve)))
