(ns ser.ver
  (:require [ring.adapter.jetty :as j]
            [ring.util.response :refer [content-type]]
            [ring.middleware.cors :refer [wrap-cors]]))

(defn serve []
  (let [s (atom 0)]
    (j/run-jetty
     (wrap-cors
      (fn [req]
        (content-type
         {:status 200
          :body (str (swap! s inc))}
         "text/plain"))
      :access-control-allow-origin [#"http://localhost:8000"]
      :access-control-allow-methods [:get])
     {:join? false
      :port 3000})))
(comment
  (def s (serve)))
